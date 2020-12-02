package de.oderkerk.tools.lkz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Entity for accessing all country code data
 * 
 * @author Odin
 * @version 11-2020
 *
 */
@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lkz")
public class LKZEntity {

	@Id
	@Column(length = 80)
	private String laendername;	
	@Column(name = "bev_gebiet")
	private Integer destatisBEVCodeGebiet;
	@Column(name = "bev_staatang")
	private Integer destatisBEVCodeStaatsang;
	@Column(name = "bev_staat")
	private Integer destatisBEVCodeStaat;
	@Column(length = 2)
	private String iso316612;
	@Column(length = 3)
	private String iso316613;	
	private Integer iso31661num;
	@Column(length = 2, name="banklkz2")	
	private String dBankLKZ2;
	@Column(name = "banklkznum")
	private Integer dBankLKZnum;
	@Column(length = 20, name ="banklkzkurz")
	private String dBankLandkuerzel;
	@Column(length = 10, name="bankwaehrungcode")
	private String dBankwaehrungcode;
	@Column(length = 3)
	private String icao;
	@Column(length = 2,name="aussenhandelcode")
	private String destatisAussenhandelsCode;
	@Column(length=3, name="kfzkennzeichen")
	private String kfzKennzeichen;
	@Column(length=80,name="postadrfeld")
	private String laenderzusatzAdressFeldPost;
	@Column(length=80,name="vollform")
	private String vollform;
	
	
}
