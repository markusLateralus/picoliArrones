package vistaInfo;


import modelo.Tipo;

public class EjercitoInfo {
	private int ejercitoID;
	private int idBattallonActual;
	private Tipo tipoActual;
	private int infanteria;
	private int caballeria;
	private int arqueria;

	

	public EjercitoInfo(int armyID, int currentBattalion, Tipo currentSquad, int infanteria, int caballeria,
			int arqueria) {
		super();
		this.ejercitoID = armyID;
		this.idBattallonActual = currentBattalion;
		this.tipoActual = currentSquad;
		this.infanteria = infanteria;
		this.caballeria = caballeria;
		this.arqueria = arqueria;
	}

	public int getArmyID() {
		return ejercitoID;
	}

	public Tipo getCurrentSquad() {
		return tipoActual;
	}

	public int getIdBatallonActual() {
		return idBattallonActual;
	}

	public int getInfanteria() {
		return infanteria;
	}

	public int getCaballeria() {
		return caballeria;
	}

	public int getArqueria() {
		return arqueria;
	}
	
	
}
