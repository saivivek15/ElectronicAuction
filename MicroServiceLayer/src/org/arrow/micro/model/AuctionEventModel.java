package org.arrow.micro.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
@Entity
public class AuctionEventModel {
	@Column(name="auctionId")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "auctionids")
	@SequenceGenerator(name="auctionids",sequenceName="auctionids" ,allocationSize = 1)
	@Id
	private int auctionId;
	private String name;
	private String description;
	private int status;
	private Double startingBid;
	private Date startDateTime;
	private Date scheduledEndDate;
	private Date actualEndDate;
	private Double reserveAmount;
	private Double minBidIncrement;
	
	@OneToOne
	private ItemModel item;
	
	@ElementCollection
	@JoinTable(name="Bids",joinColumns=@JoinColumn(name="AuctionId"))
	@GenericGenerator(name="native-gen", strategy="native")
	@CollectionId(columns = { @Column(name="BidId")}, generator = "native-gen",
							type = @Type(type="long"))
	private Collection<BidModel> bidModels = new ArrayList<BidModel>();
	
	public AuctionEventModel() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Double getStartingBid() {
		return startingBid;
	}
	public void setStartingBid(Double startingBid) {
		this.startingBid = startingBid;
	}
	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date date) {
		this.startDateTime = date;
	}
	public Date getScheduledEndDate() {
		return scheduledEndDate;
	}
	public void setScheduledEndDate(Date date) {
		this.scheduledEndDate = date;
	}
	public Date getActualEndDate() {
		return actualEndDate;
	}
	public void setActualEndDate(Timestamp actualEndDate) {
		this.actualEndDate = actualEndDate;
	}
	public Double getReserveAmount() {
		return reserveAmount;
	}
	public void setReserveAmount(Double reserveAmount) {
		this.reserveAmount = reserveAmount;
	}
	public Double getMinBidIncrement() {
		return minBidIncrement;
	}
	public void setMinBidIncrement(Double minBidIncrement) {
		this.minBidIncrement = minBidIncrement;
	}

	public ItemModel getItem() {
		return item;
	}

	public void setItem(ItemModel item) {
		this.item = item;
	}
	
	public int getAuctionId() {
		return this.auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public Collection<BidModel> getBidModel() {
		return bidModels;
	}

	public void setBidModel(List<BidModel> bidModels) {
		this.bidModels = bidModels;
	}
	
	//special functions.
	public void addBidModel(BidModel bm){
		bidModels.add(bm);
	}
	
	public void getBid(UserDetailsModel uid){
		uid.getUserId();
		
	}
	public void delBidModel(UserDetailsModel um){
		//BidModel bm = new BidModel(um.getUserId());
	//	bidModels.remove(bm);
	}
	
	
	
}
