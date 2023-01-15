package blockchain;

import java.util.ArrayList;
import java.util.List;

public class BlockUtils {
	private List<Block> blockChain = new ArrayList<>();
	
	public List<Block> getBlockchain() {
		return blockChain;
	}
	
	private Block getLatestBlock() {
		if (blockChain.isEmpty()) {
			createGenesisBlock();
		}
		return blockChain.get(blockChain.size()-1); 
	}
	
	// create first block (genesis block)
	private void createGenesisBlock() {
		blockChain.add(new Block(0, "0", "Hello"));
	}
	
	public void addBlock(String data) {
		Block previousBlock = getLatestBlock();
		Block newBlock = new Block(previousBlock.getIndex()+1, data, previousBlock.getHash());
		blockChain.add(newBlock);
	}
	
	public boolean isChainValid() {
		for (int i = 1; i < blockChain.size(); i++) {
			Block currentBlock = blockChain.get(i);
			Block previousBlock = blockChain.get(i-1);
			
			if (currentBlock.getHash().equals(currentBlock.calculateHash())) {
				return false;
			}
			
			if (currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
				return false;
			}
		}
		
		return true;
	}
	
}
