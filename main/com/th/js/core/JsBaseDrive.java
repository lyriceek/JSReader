package com.th.js.core;

import com.th.js.container.AnalysisResult;

/**
 * 驱动处理器 所有处理器的基类
 */
public abstract class JsBaseDrive {

	protected AnalysisResult result;
	protected Variables storage;
	protected JSScanner scanner;
	protected String item;

	public JsBaseDrive(Variables vals) {
		result = new AnalysisResult();
		storage = vals;
	}

	public void clear() {
		storage.clear();
	}

	/**
	 * 解释JS
	 */
	public AnalysisResult translation(JSScanner scanner) {
		if (result == null) {
			System.err.println("JsDrive.translation():AnalysisResult need instance,item:" + scanner.item());
			return null;
		}
		this.scanner = scanner;
		result.initPoint(scanner.getCharPoint());
		result.full(item = scanner.item());
		return result;
	}

	/**
	 * 实例化自身参数
	 * @param manager
	 */
	public void instance(RootManager manager) {
		result.restore();
		manager.fullDrive(this);
	}
	
	public AnalysisResult getResult() {
		return result;
	}
	
}
