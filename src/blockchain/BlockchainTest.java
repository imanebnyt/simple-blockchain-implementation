package blockchain;


public class BlockchainTest {
	public static void main(String[] args) {
		BlockUtils blockUtils  = new BlockUtils();
		blockUtils.addBlock("100");
		blockUtils.addBlock("200");
		blockUtils.addBlock("300");
		
		System.out.println(blockUtils.isChainValid());
		
		blockUtils.getBlockchain().get(2).setData("5000"); 
		
		System.out.println(blockUtils.isChainValid());
	}

}
