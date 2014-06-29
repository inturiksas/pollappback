package us.pollapp.inturik.DTO;

import java.util.Date;

public class ContextResponseDTO {

	private String idTransaction;
	private Date transactionDate;
	private boolean transactionState;

	public String getIdTransaccion() {
		return idTransaction;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaction = idTransaccion;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public boolean isTransactionState() {
		return transactionState;
	}

	public void setTransactionState(boolean transactionState) {
		this.transactionState = transactionState;
	}

}
