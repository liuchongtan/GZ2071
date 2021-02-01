package 刘少的复习;

public class 冒泡排序3 {

	public static void main(String[] args) {
//比较相邻的元素。如果第一个比第二个大，就交换他们两个。
//对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
//在这一点，最后的元素应该会是最大的数。
//针对所有的元素重复以上的步骤，除了最后一个，即需要进行length-1次。
//第一次是对n个数进行n-1次比较，进行到最后第n个的一个是最大的；
//第二次是对n-1个数进行n-2次比较，进行到最后第n-1个的一个是最大的；
//测试合并！！！！！！！！！！

		//把数组从小到大排序
		int[] numbers= {7,15,3,8,13,9,1,75,30,21,11};
		int temp;
	    for(int i=0;i<numbers.length-1;i++) {
	    	for(int j=0;j<numbers.length-1-i;j++) {
	    		if(numbers[j]>numbers[j+1]) {
	    			temp=numbers[j];
	    			numbers[j]=numbers[j+1];
	    			numbers[j+1]=temp;
	    			
	    		}	    		
	    	}
	    	
	    }	

	    for(int k=0;k<numbers.length;k++) {
	    	System.out.print(numbers[k]+" ");
	    }
	System.out.println();
	}}
