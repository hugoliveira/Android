package pt.ua.easyCaching;

public class Cache {
	private int idCache;
	private String nome;
	private String descricao;
	private String hint;
	private float terrain;
	private float difficulty;
	private float size;
	private String owner;
	private float latitude;
	private float longitude;
	
	public Cache(){}
	
	
	public int getIdCache() {
		return idCache;
	}
	
	
	public void setIdCache(int idCache) {
		this.idCache = idCache;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public float getTerrain() {
		return terrain;
	}
	public void setTerrain(float terrain) {
		this.terrain = terrain;
	}
	public float getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(float difficulty) {
		this.difficulty = difficulty;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
}
