package com.autoStock.backtest.encog;

import java.util.ArrayList;

import org.encog.ml.MLMethod;
import org.encog.ml.MLRegression;
import org.encog.neural.networks.training.CalculateScore;
import org.w3c.dom.ls.LSInput;

import com.autoStock.algorithm.core.AlgorithmDefinitions.AlgorithmMode;
import com.autoStock.algorithm.core.AlgorithmRemodeler;
import com.autoStock.backtest.AlgorithmModel;
import com.autoStock.backtest.BacktestEvaluation;
import com.autoStock.backtest.BacktestEvaluationBuilder;
import com.autoStock.backtest.SingleBacktest;
import com.autoStock.signal.SignalCache;
import com.autoStock.tools.Benchmark;
import com.autoStock.trading.types.HistoricalData;

/**
 * @author Kevin Kowalewski
 *
 */
public class EncogScoreProvider implements CalculateScore {
	private HistoricalData historicalData;	
	public static long runCount;
	private AlgorithmModel algorithmModel;
	public static ArrayList<EncogResult> listOfEncogResult = new ArrayList<EncogResult>();
	private SignalCache signalCache;
	private Benchmark bench = new Benchmark();
	
	public void setDetails(AlgorithmModel algorithmModel, HistoricalData historicalData){
		this.algorithmModel = algorithmModel;
		this.historicalData = historicalData;
		listOfEncogResult.clear();
	}
	
	@Override
	public double calculateScore(MLRegression network) {
//		Co.print("--> Calculate score... " + algorithmModel.getUniqueIdentifier() + " ");
		//Co.println(BacktestEvaluationReader.getPrecomputedEvaluation(exchange, symbol).toString());
		
		bench.tick();
		
		SingleBacktest singleBacktest = new SingleBacktest(historicalData, AlgorithmMode.mode_backtest_single);
//		singleBacktest.backtestContainer.algorithm.algorithmMode.populateTable = false;
		new AlgorithmRemodeler(singleBacktest.backtestContainer.algorithm, algorithmModel).remodel(true, true, true, false);
		singleBacktest.selfPopulateBacktestData();
		singleBacktest.backtestContainer.algorithm.signalGroup.signalOfEncog.setNetwork(network, 0);
//		singleBacktest.backtestContainer.setSignalCache(signalCache);
		singleBacktest.runBacktest();
		
		BacktestEvaluation backtestEvaluation = new BacktestEvaluationBuilder().buildEvaluation(singleBacktest.backtestContainer, false, false, true);
		
		runCount++;
		
		double score = backtestEvaluation.getScore();
		
		return score;
	}

	@Override
	public boolean shouldMinimize() {
		return false;
	}
	
	public static class EncogResult {
		public MLRegression network;
		public BacktestEvaluation backtestEvaluation;
		public String table;
		
		public EncogResult(MLRegression network, BacktestEvaluation backtestEvaluation, String table) {
			this.network = network;
			this.backtestEvaluation = backtestEvaluation;
			this.table = table;
		}
	}

	public void setSignalCache(SignalCache signalCache) {
		this.signalCache = signalCache;
	}

	public AlgorithmModel getAlgorithmModel() {
		return algorithmModel;
	}
}
