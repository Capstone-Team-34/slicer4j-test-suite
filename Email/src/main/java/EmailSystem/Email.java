package EmailSystem;
import tests.TestCommand;

public   class  Email {
	

	protected int id;

	
	protected String subject;

	
	protected String body;

	
	protected Client from;

	
	protected String to;

	
	
	static int emailCounter = 1;

	

	public Email(int id) {
		this.id = id;
	}

	

	static Email createEmail(Client from, String to, String subject, String body) {
		Email msg = new Email(++emailCounter);
		msg.setEmailFrom(from);
		msg.setEmailTo(to);
		msg.setEmailSubject(subject);
		msg.setEmailBody(body);
		return msg;
	}

	

	boolean  isReadable__before__encrypt() {
		return true;
	}

	

	boolean  isReadable__role__encrypt() {
		if (!isEncrypted())
			return isReadable__before__encrypt();
		else
			return false;
	}

	
	
	boolean
isReadable() {
    return isEncrypted;
}



	

	static void  printMail__before__encrypt(Email msg) {
		Util.prompt("ID:  " + msg.getId());
		Util.prompt("FROM: " + msg.getEmailFrom().getId());
		Util.prompt("TO: " + msg.getEmailTo());
		Util.prompt("SUBJECT: " + msg.getEmailSubject());
		Util.prompt("IS_READABLE " + msg.isReadable());
		Util.prompt("BODY: " + msg.getEmailBody());
	}

	

	static void  printMail__role__encrypt(Email msg) {
		printMail__before__encrypt(msg);
		Util.prompt("ENCRYPTED " + msg.isEncrypted());
		// Util.prompt("ENCRYPTION KEY  "+ msg.getEmailEncryptionKey());
	}

	
	
	static void 
printMail__before__sign(Email msg) {
    if (TestCommand.get_ENCRYPT___()) {
        printMail__role__encrypt(msg);
    } else {
        printMail__before__encrypt(msg);
    }
}



	
	
	static void  printMail__role__sign(Email msg) {
		printMail__before__sign(msg);
		Util.prompt("SIGNED " + msg.isSigned());
		Util.prompt("SIGNATURE " + msg.getEmailSignKey());
	}

	
	
	static void 
printMail__before__verify(Email msg) {
    if (TestCommand.get_SIGN___()) {
        printMail__role__sign(msg);
    } else {
        printMail__before__sign(msg);
    }
}



	
	
	static void  printMail__role__verify(Email msg) {
		printMail__before__verify(msg);
		Util.prompt("SIGNATURE VERIFIED " + msg.isSignatureVerified());
	}

	
	
	static void
printMail(Email msg) {
    if (TestCommand.get_VERIFY___()) {
        printMail__role__verify(msg);
    } else {
        printMail__before__verify(msg);
    }
}

	Email cloneEmail(Email msg) {
		try {
			return (Email) this.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error("Clone not supported");
		}
	}

	

	Client getEmailFrom() {
		return from;
	}

	

	int getId() {
		return id;
	}

	

	String getEmailSubject() {
		return subject;
	}

	

	String getEmailTo() {
		return to;
	}

	

	void setEmailBody(String value) {
		body = value;
	}

	

	void setEmailFrom(Client value) {
		this.from = Client.createClient(value.name);
	}

	

	void setEmailSubject(String value) {
		this.subject = value;
	}

	

	void setEmailTo(String value) {
		to = value;
	}

	

	String getEmailBody() {
		return body;
	}

	
	protected boolean isEncrypted;

	
	protected int encryptionKey;

	
	
	boolean isEncrypted() {
		return isEncrypted;
	}


	void setEmailIsEncrypted(boolean value) {
		TestCommand.ENCRYPT___ = value;
		isEncrypted = value;
	}

	

	void setEmailEncryptionKey(int value) {
		this.encryptionKey = value;
	}

	

	int getEmailEncryptionKey() {
		return encryptionKey;
	}

	
	protected boolean signed;

	
	protected int signkey;

	
	
	void setEmailIsSigned(boolean value) {
		signed = value;
	}

	

	void setEmailSignKey(int value) {
		signkey = value;
	}

		
	
	boolean isSigned() {
		return signed;
	}

	
	
	int getEmailSignKey() {
		return signkey;
	}

	
	protected boolean isSignatureVerified;

	

	boolean isSignatureVerified() {
		return isSignatureVerified;
	}

	

	void setIsSignatureVerified(boolean value) {
		this.isSignatureVerified = value;
	}

}
