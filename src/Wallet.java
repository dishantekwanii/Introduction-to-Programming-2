public class Wallet {
	private float Wallet = 0;

	public float getWallet(){
		return Wallet;
	}

	public void addToWallet(float money) {
		Wallet =  Wallet + money;
	}

	public void removeFromWallet(float money) {

		Wallet = Wallet - money;
	}
}