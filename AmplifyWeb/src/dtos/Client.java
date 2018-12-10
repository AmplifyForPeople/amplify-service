package dtos;



public class Client {

    public int id;
    public String name;
    public String password;
    public String email;
    public String phone;
    public Establishment establishment;

    public Client() {
    	super();	
    }
	public Client(entity.Client client_to_parse) {
		super();
		this.id = client_to_parse.getId();
    	this.name=client_to_parse.getName();
    	this.password=client_to_parse.getPassword();
    	this.email=client_to_parse.getEmail();
    	this.phone=client_to_parse.getPhone();
    	this.establishment = new Establishment();
    	this.establishment.id=client_to_parse.getEstablishment().getId();
    	this.establishment.name=client_to_parse.getEstablishment().getName();
    	this.establishment.info=client_to_parse.getEstablishment().getInfo();
    	this.establishment.position_lat=client_to_parse.getEstablishment().getPosition_lat();
    	this.establishment.position_lng=client_to_parse.getEstablishment().getPosition_lng();
    	this.establishment.imatge=client_to_parse.getEstablishment().getImatge();
    }
    
}