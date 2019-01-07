
public class BeanJSon {
	
	private int code;
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	
	public BeanJSon()
	{
		code = 0;
		name = new String();
	}

}
