package algorithm.basic.huffman;

/**
 *  the node only record code for encoding.
 *
 */
class HuffmanNode<T> implements Comparable<HuffmanNode> {
		
		private T chars ;
		private int frequence = 0;
		private int pathCode = -1;
		private String encode="";
		private HuffmanNode<T> parent;

		public HuffmanNode()
		{
		}
		
		public HuffmanNode(T s)
		{
			this.chars = s;
		}
		
		public boolean equals(java.lang.Object arg0)
		{
			return false;
		}
		public String toString()
		{
			return "c="+chars+",fre="+frequence+",code="+pathCode;
		}
	
		/**
		 * 
		 */
		public int compareTo(HuffmanNode n) {
			if (this.frequence > n.frequence) {
				return 1;
			} else {
				return -1;
			}
		}


		public boolean isRoot() {
			return parent == null;
		}

		public int getCode() {
			return pathCode;
		}

		public void setCode(int code) {
			this.pathCode = code;
		}
		

		public int getFrequence() {
			return frequence;
		}

		public void setFrequence(int frequence) {
			this.frequence = frequence;
		}

		public T getChars() {
			return chars;
		}

		public void setChars(T chars) {
			this.chars = chars;
		}

		public HuffmanNode getParent() {
			return parent;
		}

		public void setParent(HuffmanNode parent) {
			this.parent = parent;
		}

		public String getEncode() {
			return encode;
		}

		public void setEncode(String encode) {
			this.encode = encode;
		}

	 

	}

