package com.autoStock.position;

import com.autoStock.position.PositionGovernorResponse.PositionGovernorResponseReason;
import com.autoStock.position.PositionGovernorResponse.PositionGovernorResponseStatus;
import com.autoStock.position.PositionDefinitions.PositionType;
import com.autoStock.signal.Signal;
import com.autoStock.signal.SignalDefinitions.SignalPoint;
import com.autoStock.signal.SignalPointMethod;
import com.autoStock.signal.SignalPointMethod.SignalPointTactic;
import com.autoStock.strategy.StrategyOptions;
import com.autoStock.trading.types.Position;
import com.autoStock.types.Exchange;
import com.autoStock.types.QuoteSlice;

/**
 * @author Kevin Kowalewski
 *
 */
public class PositionGovernor {
	private static PositionGovernor instance = new PositionGovernor();
	private PositionManager positionManager = PositionManager.instance; 
	
	public static PositionGovernor getInstance(){
		return instance;
	}
	
	public synchronized PositionGovernorResponse informGovener(QuoteSlice quoteSlice, Signal signal, Exchange exchange, StrategyOptions strategyOptions){
		PositionGovernorResponse positionGovernorResponse = new PositionGovernorResponse();
		Position position = positionManager.getPosition(quoteSlice.symbol);
		SignalPoint signalPoint = SignalPoint.none;
		
		if (position == null){
			signalPoint = SignalPointMethod.getSignalPoint(false, signal, PositionType.position_none, strategyOptions.signalPointTactic);
			
			if (signalPoint == SignalPoint.long_entry && strategyOptions.canGoLong){
				governLongEntry(quoteSlice, signal, positionGovernorResponse);
			}else if (signalPoint == SignalPoint.short_entry && strategyOptions.canGoShort){
				governShortEntry(quoteSlice, signal, positionGovernorResponse);
			}
			
		} else {
			boolean algorithmConditionExit = false;
			signalPoint = SignalPointMethod.getSignalPoint(true, signal, position.positionType, strategyOptions.signalPointTactic);
			
			PositionGovernorResponse tempPositionGovernorResponse = new PositionGovernorResponse();

			if (position.positionType == PositionType.position_long || position.positionType == PositionType.position_long_entry) {
				if (signalPoint == SignalPoint.long_exit || algorithmConditionExit) {
					governLongExit(quoteSlice, position, signal, positionGovernorResponse);
				}
			}else if (position.positionType == PositionType.position_short || position.positionType == PositionType.position_short_entry) {
				if (signalPoint == SignalPoint.short_exit || algorithmConditionExit) {
					governShortExit(quoteSlice, position, signal, positionGovernorResponse);
				}
			}else {
				throw new IllegalStateException();
			}
			
			if (tempPositionGovernorResponse.status == PositionGovernorResponseStatus.failed){
				return tempPositionGovernorResponse;
			}
		}
		
		positionGovernorResponse.signalPoint = signalPoint;
		signal.currentSignalPoint = signalPoint;

		return positionGovernorResponse;
	} 
	
	private void governLongEntry(QuoteSlice quoteSlice, Signal signal, PositionGovernorResponse positionGovernorResponse){
		Position position = positionManager.executePosition(quoteSlice, signal, PositionType.position_long_entry);
		if (position == null){
			positionGovernorResponse.getFailedResponse(PositionGovernorResponseReason.failed_insufficient_funds);
		}else{
			positionGovernorResponse.position = position;
			positionGovernorResponse.status = PositionGovernorResponseStatus.status_changed_long_entry;
		}
	}
	
	private void governShortEntry(QuoteSlice quoteSlice, Signal signal, PositionGovernorResponse positionGovernorResponse){
		Position position = positionManager.executePosition(quoteSlice, signal, PositionType.position_short_entry);
		if (position == null){
			positionGovernorResponse.getFailedResponse(PositionGovernorResponseReason.failed_insufficient_funds);
		}else{
			positionGovernorResponse.position = position;
			positionGovernorResponse.status = PositionGovernorResponseStatus.status_changed_short_entry;
		}
	}
	
	private void governLongExit(QuoteSlice quoteSlice, Position position, Signal signal, PositionGovernorResponse positionGovernorResponse){
		if (position != null && (position.positionType == PositionType.position_long_exit)){
			return;
		}
		positionGovernorResponse.position = positionManager.executePosition(quoteSlice, signal, PositionType.position_long_exit);
		positionGovernorResponse.status = PositionGovernorResponseStatus.status_changed_long_exit;
	}
	
	private void governShortExit(QuoteSlice quoteSlice, Position position, Signal signal, PositionGovernorResponse positionGovernorResponse){
		if (position != null && (position.positionType == PositionType.position_short_exit)){
			return;
		}
		positionGovernorResponse.position = positionManager.executePosition(quoteSlice, signal, PositionType.position_short_exit);
		positionGovernorResponse.status = PositionGovernorResponseStatus.status_changed_short_exit;
	}
}
