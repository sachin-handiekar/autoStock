package com.autoStock.backtest.watchmaker;

import java.util.ArrayList;

import com.autoStock.adjust.AdjustmentBase;
import com.autoStock.adjust.AdjustmentOfBasicDouble;
import com.autoStock.adjust.AdjustmentOfBasicInteger;
import com.autoStock.adjust.AdjustmentOfEnum;
import com.autoStock.adjust.AdjustmentOfSignalMetricThreshold;
import com.autoStock.adjust.IterableOfDouble;
import com.autoStock.adjust.IterableOfEnum;
import com.autoStock.adjust.IterableOfInteger;
import com.autoStock.adjust.AdjustmentCampaign.AdjustmentType;
import com.autoStock.algorithm.AlgorithmBase;
import com.autoStock.signal.SignalBase;
import com.autoStock.signal.SignalDefinitions.SignalGuageType;
import com.autoStock.signal.SignalDefinitions.SignalParametersForCrossover;
import com.autoStock.signal.SignalDefinitions.SignalParametersForUO;
import com.autoStock.signal.TacticResolver.SignalPointTactic;

/**
 * @author Kevin Kowalewski
 *
 */
public class WMAdjustmentProvider {
	public ArrayList<AdjustmentBase> getListOfAdjustmentBase(AlgorithmBase algorithmBase){
		ArrayList<AdjustmentBase> listOfAdjustmentBase = new ArrayList<AdjustmentBase>();
		
//     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("Period length EMA 1", algorithmBase.indicatorGroup.indicatorOfEMAFirst.indicatorParameters.periodLength, new IterableOfInteger(3, 60, 1)));
//     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("Period length EMA 2", algorithmBase.indicatorGroup.indicatorOfEMASecond.indicatorParameters.periodLength, new IterableOfInteger(3, 60, 1)));
//     	listOfAdjustmentBase.add(new AdjustmentOfBasicDouble("Long gap size", ((SignalParametersForCrossover)algorithmBase.signalGroup.signalOfCrossover.signalParameters).longGapSize, new IterableOfDouble(-15, 15, 0.25)));
//     	listOfAdjustmentBase.add(new AdjustmentOfBasicDouble("Short gap size", ((SignalParametersForCrossover)algorithmBase.signalGroup.signalOfCrossover.signalParameters).shortGapSize, new IterableOfDouble(-15, 15, 0.25)));
		
//		addTypicalSignalRange(listOfAdjustmentBase, algorithmBase.signalGroup.signalOfUO);
		addTypicalSignalRange(listOfAdjustmentBase, algorithmBase.signalGroup.signalOfCCI);
//		addTypicalSignalRange(listOfAdjustmentBase, algorithmBase.signalGroup.signalOfDI);
//		addTypicalSignalRange(listOfAdjustmentBase, algorithmBase.signalGroup.signalOfRSI);
//		addTypicalSignalRange(listOfAdjustmentBase, algorithmBase.signalGroup.signalOfWILLR);

//		addTypicalSignalRange(listOfAdjustmentBase, algorithmBase.signalGroup.signalOfARUp);
//		addTypicalSignalRange(listOfAdjustmentBase, algorithmBase.signalGroup.signalOfARDown);
//		listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("Period length", algorithmBase.indicatorGroup.indicatorOfAR.indicatorParameters.periodLength, new IterableOfInteger(20, 60, 1)));
		
//     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("Period length", algorithmBase.indicatorGroup.indicatorOfUO.indicatorParameters.periodLength, new IterableOfInteger(20, 60, 1)));
     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("Period length", algorithmBase.indicatorGroup.indicatorOfCCI.indicatorParameters.periodLength, new IterableOfInteger(20, 60, 1)));
//     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("Period length", algorithmBase.indicatorGroup.indicatorOfDI.indicatorParameters.periodLength, new IterableOfInteger(20, 60, 1)));
//     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("Period length", algorithmBase.indicatorGroup.indicatorOfRSI.indicatorParameters.periodLength, new IterableOfInteger(20, 60, 1)));
//     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("Period length", algorithmBase.indicatorGroup.indicatorOfWILLR.indicatorParameters.periodLength, new IterableOfInteger(20, 60, 1)));
//     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("Average UO", algorithmBase.signalGroup.signalOfUO.signalParameters.maxSignalAverage, new IterableOfInteger(1, 20, 1)));
     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("Average CCI", algorithmBase.signalGroup.signalOfCCI.signalParameters.maxSignalAverage, new IterableOfInteger(1, 20, 1)));
//     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("Average DI", algorithmBase.signalGroup.signalOfDI.signalParameters.maxSignalAverage, new IterableOfInteger(1, 20, 1)));
//     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("Average RSI", algorithmBase.signalGroup.signalOfRSI.signalParameters.maxSignalAverage, new IterableOfInteger(1, 20, 1)));
//     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("Average WILLR", algorithmBase.signalGroup.signalOfWILLR.signalParameters.maxSignalAverage, new IterableOfInteger(1, 20, 1)));
//
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("UO Guage Long Entry", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left), algorithmBase.signalGroup.signalOfUO.signalParameters.arrayOfSignalGuageForLongEntry[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("UO Guage Long Exit", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left), algorithmBase.signalGroup.signalOfUO.signalParameters.arrayOfSignalGuageForLongExit[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("UO Guage Short Entry", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left), algorithmBase.signalGroup.signalOfUO.signalParameters.arrayOfSignalGuageForShortEntry[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("UO Guage Short Exit", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left), algorithmBase.signalGroup.signalOfUO.signalParameters.arrayOfSignalGuageForShortExit[0].mutableEnumForSignalGuageType));

		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("CCI Guage Long Entry 0", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_trough, SignalGuageType.custom_always_true), algorithmBase.signalGroup.signalOfCCI.signalParameters.arrayOfSignalGuageForLongEntry[0].mutableEnumForSignalGuageType));
		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("CCI Guage Long Exit 0", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_peak, SignalGuageType.custom_always_true), algorithmBase.signalGroup.signalOfCCI.signalParameters.arrayOfSignalGuageForLongExit[0].mutableEnumForSignalGuageType));
		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("CCI Guage Short Entry 0", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_peak, SignalGuageType.custom_always_true), algorithmBase.signalGroup.signalOfCCI.signalParameters.arrayOfSignalGuageForShortEntry[0].mutableEnumForSignalGuageType));
		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("CCI Guage Short Exit 0", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_trough, SignalGuageType.custom_always_true), algorithmBase.signalGroup.signalOfCCI.signalParameters.arrayOfSignalGuageForShortExit[0].mutableEnumForSignalGuageType));
     	
		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("CCI Guage Long Entry 1", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left, SignalGuageType.custom_always_true), algorithmBase.signalGroup.signalOfCCI.signalParameters.arrayOfSignalGuageForLongEntry[1].mutableEnumForSignalGuageType));
		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("CCI Guage Long Exit 1", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left, SignalGuageType.custom_always_true), algorithmBase.signalGroup.signalOfCCI.signalParameters.arrayOfSignalGuageForLongExit[1].mutableEnumForSignalGuageType));
		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("CCI Guage Short Entry 1", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left, SignalGuageType.custom_always_true), algorithmBase.signalGroup.signalOfCCI.signalParameters.arrayOfSignalGuageForShortEntry[1].mutableEnumForSignalGuageType));
		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("CCI Guage Short Exit 1", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left, SignalGuageType.custom_always_true), algorithmBase.signalGroup.signalOfCCI.signalParameters.arrayOfSignalGuageForShortExit[1].mutableEnumForSignalGuageType));
		
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("DI Guage Long Entry", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left, SignalGuageType.custom_always_true, SignalGuageType.custom_always_false), algorithmBase.signalGroup.signalOfDI.signalParameters.arrayOfSignalGuageForLongEntry[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("DI Guage Long Exit", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left, SignalGuageType.custom_always_true, SignalGuageType.custom_always_false), algorithmBase.signalGroup.signalOfDI.signalParameters.arrayOfSignalGuageForLongExit[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("DI Guage Short Entry", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left, SignalGuageType.custom_always_true, SignalGuageType.custom_always_false), algorithmBase.signalGroup.signalOfDI.signalParameters.arrayOfSignalGuageForShortEntry[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("DI Guage Short Exit", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left, SignalGuageType.custom_always_true, SignalGuageType.custom_always_false), algorithmBase.signalGroup.signalOfDI.signalParameters.arrayOfSignalGuageForShortExit[0].mutableEnumForSignalGuageType));


//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("RSI Guage Long Entry", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left), algorithmBase.signalGroup.signalOfRSI.signalParameters.arrayOfSignalGuageForLongEntry[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("RSI Guage Long Exit", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left), algorithmBase.signalGroup.signalOfRSI.signalParameters.arrayOfSignalGuageForLongExit[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("RSI Guage Short Entry", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left), algorithmBase.signalGroup.signalOfRSI.signalParameters.arrayOfSignalGuageForShortEntry[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("RSI Guage Short Exit", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left), algorithmBase.signalGroup.signalOfRSI.signalParameters.arrayOfSignalGuageForShortExit[0].mutableEnumForSignalGuageType));
     	
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("WILLR Guage Long Entry", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left), algorithmBase.signalGroup.signalOfWILLR.signalParameters.arrayOfSignalGuageForLongEntry[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("WILLR Guage Long Exit", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left), algorithmBase.signalGroup.signalOfWILLR.signalParameters.arrayOfSignalGuageForLongExit[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("WILLR Guage Short Entry", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left), algorithmBase.signalGroup.signalOfWILLR.signalParameters.arrayOfSignalGuageForShortEntry[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>("WILLR Guage Short Exit", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left), algorithmBase.signalGroup.signalOfWILLR.signalParameters.arrayOfSignalGuageForShortExit[0].mutableEnumForSignalGuageType));
     	
		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalPointTactic>("SO Tactic Entry", new IterableOfEnum<SignalPointTactic>(SignalPointTactic.tactic_any, SignalPointTactic.tactic_combined), algorithmBase.strategyBase.strategyOptions.signalPointTacticForEntry));
		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalPointTactic>("SO Tactic Exit", new IterableOfEnum<SignalPointTactic>(SignalPointTactic.tactic_any, SignalPointTactic.tactic_combined), algorithmBase.strategyBase.strategyOptions.signalPointTacticForExit));		
		
     	listOfAdjustmentBase.add(new AdjustmentOfBasicDouble("SO maxStopLossPercent", algorithmBase.strategyBase.strategyOptions.maxStopLossPercent, new IterableOfDouble(-0.25, 0, 0.01)));
     	listOfAdjustmentBase.add(new AdjustmentOfBasicDouble("SO maxProfitDrawdownPercent", algorithmBase.strategyBase.strategyOptions.maxProfitDrawdownPercent, new IterableOfDouble(-0.25, 0, 0.01)));
     	
     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("SO intervalForReentryMins", algorithmBase.strategyBase.strategyOptions.intervalForReentryMins, new IterableOfInteger(1, 15, 1)));
     	listOfAdjustmentBase.add(new AdjustmentOfBasicDouble("SO minReentryPercentGain", algorithmBase.strategyBase.strategyOptions.minReentryPercentGain, new IterableOfDouble(0, 0.50, 0.01)));
     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("SO maxReenterTimes", algorithmBase.strategyBase.strategyOptions.maxReenterTimesPerPosition, new IterableOfInteger(1, 5, 1)));
     	
//     	listOfAdjustmentBase.add(new AdjustmentOfBasicInteger("SO entryAfterStopLossMinutes", algorithmBase.strategyBase.strategyOptions.intervalForEntryAfterExitWithLossMins, new IterableOfInteger(3, 20, 1)));

		return listOfAdjustmentBase;
	}
	
//	private void addCompleteSignalRange(ArrayList<AdjustmentBase> listOfAdjustmentBase, SignalBase signalBase){
//		addTypicalSignalRange(listOfAdjustmentBase, signalBase);
//
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>(signalBase.getClass().getSimpleName() + " - Guage Long Entry", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left, SignalGuageType.none), signalBase.signalParameters.arrayOfSignalGuageForLongEntry[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>(signalBase.getClass().getSimpleName() + " - Guage Long Exit", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left, SignalGuageType.none), signalBase.signalParameters.arrayOfSignalGuageForLongExit[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>(signalBase.getClass().getSimpleName() + " - Guage Short Entry", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left, SignalGuageType.none), signalBase.signalParameters.arrayOfSignalGuageForShortEntry[0].mutableEnumForSignalGuageType));
//		listOfAdjustmentBase.add(new AdjustmentOfEnum<SignalGuageType>(signalBase.getClass().getSimpleName() + " - Guage Short Exit", new IterableOfEnum<SignalGuageType>(SignalGuageType.guage_threshold_met, SignalGuageType.guage_threshold_left, SignalGuageType.none), signalBase.signalParameters.arrayOfSignalGuageForShortExit[0].mutableEnumForSignalGuageType));
//
//	}
	
	private void addTypicalSignalRange(ArrayList<AdjustmentBase> listOfAdjustmentBase, SignalBase signalBase){
		listOfAdjustmentBase.add(new AdjustmentOfSignalMetricThreshold(signalBase, AdjustmentType.signal_metric_long_entry, new IterableOfDouble(-35, 35, 1)));
		listOfAdjustmentBase.add(new AdjustmentOfSignalMetricThreshold(signalBase, AdjustmentType.signal_metric_long_exit, new IterableOfDouble(-35, 35, 1)));
		listOfAdjustmentBase.add(new AdjustmentOfSignalMetricThreshold(signalBase, AdjustmentType.signal_metric_short_entry, new IterableOfDouble(-35, 35, 1)));
		listOfAdjustmentBase.add(new AdjustmentOfSignalMetricThreshold(signalBase, AdjustmentType.signal_metric_short_exit, new IterableOfDouble(-35, 35, 1)));
	}
}

