package model;

public class Comprobant {
	private long id;
	private String date;
	private String idRequest;
	private String total;
	
	/**
	 * @param id
	 * @param date
	 * @param idRequest
	 * @param total
	 */
	public Comprobant(long id, String date, String idRequest, String total) {
		super();
		this.id = id;
		this.date = date;
		this.idRequest = idRequest;
		this.total = total;
	}

	public Comprobant() {
		this(0L,"","","");
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the idRequest
	 */
	public String getIdRequest() {
		return idRequest;
	}

	/**
	 * @param idRequest the idRequest to set
	 */
	public void setIdRequest(String idRequest) {
		this.idRequest = idRequest;
	}

	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comprobant [id=" + id + ", date=" + date + ", idRequest=" + idRequest + ", total=" + total + "]";
	}
	
	
	
}
