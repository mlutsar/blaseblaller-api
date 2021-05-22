package com.blaller.blaseblallerApi.blaseApi;

import java.util.List;

public class BlaseIdols {
	private List<String> idols;
	private Data data;
	
	public List<String> getIdols() {
		return idols;
	}

	public void setIdols(List<String> idols) {
		this.idols = idols;
	}

	private Data getData() {
		return data;
	}

	private void setData(Data data) {
		this.data = data;
	}
	
	private class Data {
		private int strictlyConfidential;
		

		public Data() {}

		public int getStrictlyConfidential() {
			return strictlyConfidential;
		}

		public void setStrictlyConfidential(int strictlyConfidential) {
			this.strictlyConfidential = strictlyConfidential;
		}
	}
}

