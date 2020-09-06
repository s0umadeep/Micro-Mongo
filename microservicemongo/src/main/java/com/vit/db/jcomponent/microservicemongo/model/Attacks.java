package com.vit.db.jcomponent.microservicemongo.model;

public class Attacks {

	String attackName;
	Float attackPer;
	String attackLevel;
	/**
	 * @return the attackName
	 */
	public String getAttackName() {
		return attackName;
	}
	/**
	 * @param attackName the attackName to set
	 */
	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}
	/**
	 * @return the attackPer
	 */
	public Float getAttackPer() {
		return attackPer;
	}
	/**
	 * @param attackPer the attackPer to set
	 */
	public void setAttackPer(Float attackPer) {
		this.attackPer = attackPer;
	}
	/**
	 * @return the attackLevel
	 */
	public String getAttackLevel() {
		return attackLevel;
	}
	/**
	 * @param attackLevel the attackLevel to set
	 */
	public void setAttackLevel(String attackLevel) {
		this.attackLevel = attackLevel;
	}
	/**
	 * @param attackName
	 * @param attackPer
	 * @param attackLevel
	 */
	public Attacks(String attackName, Float attackPer, String attackLevel) {
		super();
		this.attackName = attackName;
		this.attackPer = attackPer;
		this.attackLevel = attackLevel;
	}
	@Override
	public String toString() {
		return "Attacks [attackName=" + attackName + ", attackPer=" + attackPer + ", attackLevel=" + attackLevel + "]";
	}
	
}
