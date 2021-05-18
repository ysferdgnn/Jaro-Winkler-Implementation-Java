package jaroWinkler;

public class JaroWinklerImp {
	
	
	private double threshold=0.7;
	
	public JaroWinklerImp() {};
	public JaroWinklerImp(double threshold) {
		this.threshold=threshold;
		
	};

public double Jaro(String text1,String text2) {
		
		Integer text1Len = text1.length();
		Integer text2Len =text2.length();
		Integer distance; //How far we can go from char 
		Integer transposeCount=0;
		Integer matchCount=0;
		
		//if text is null dont check
		if(text1Len==0 || text2Len==0) {return 0;}
		
		distance=Integer.valueOf((int) Math.floor(((Math.max(text1Len, text2Len))/2)-1)) ;
		
		if(distance==0) {return 0;}
		
		for (int i = 0; i < Math.min(text1Len, text2Len); i++) {
			
			for (int j = Math.max(0,i-distance); j < Math.min(i+distance+1, text2Len) ; j++) {
				
				if(text1.charAt(i) == text2.charAt(j)) {
					matchCount++;
					
					
					char a = text1.charAt(i);
					char b = text2.charAt(j);
					char c = text1.charAt(j);
					char d =text2.charAt(i);
					
					if(d==c && a!=c) {
						transposeCount++;
					}
					
					break;
				}
				
			}
			
		}
		
		transposeCount=transposeCount/2; //transpose count is half 
		if (matchCount==0)
			return 0;
		
		double text1Rate = (double)matchCount/(double)text1Len;
		double text2Rate =(double)matchCount/(double)text2Len;
		double transposeRate = ((double)matchCount-(double)transposeCount)/(double)matchCount;
		
		System.out.println("\n");
		System.out.println("Match Count: "+matchCount);
		System.out.println("Transpose Count: "+transposeCount);
		System.out.println("Text 1/Match Count :"+text1Rate);
		System.out.println("Text 2/Match Count :"+text2Rate);
		System.out.println("Transpose Count/Match Count :"+transposeRate);
		
		double jaroSimilarity=((text1Rate)+(text2Rate)+(transposeRate))/3;
		
		return jaroSimilarity;
	}
public double JaroWinkler(String text1,String text2) {
		
		//prefix can be 4 max
		double prefix =0;
		double jaroSimilarity = this.Jaro(text1, text2);
		
		
		if(jaroSimilarity>this.threshold) {
			for (int i = 0; i < Math.min(text1.length(), text2.length()); i++) {
				
				if(text1.charAt(i)==text2.charAt(i)) {
					prefix++;
				}
			}
			
			prefix=Math.min(4, prefix);
			
			jaroSimilarity += 0.1*prefix*(1-jaroSimilarity);
			
			
		}
		return jaroSimilarity;
		
	}
}
