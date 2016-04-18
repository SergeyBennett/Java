
public class Percolation {
	QuickFindUF netElements;
	int N;
	int openCount;
	boolean[] opentruth;
	public Percolation(int N) {
		this.netElements=new QuickFindUF((int)Math.pow(N, 2)+2);
		this.N=N;
		this.openCount=0;
		this.opentruth=new boolean[(int)Math.pow(N, 2)];
		for(int i=0;i<N;i++){
			this.netElements.union(i, (int)Math.pow(N, 2));
			this.netElements.union((int)Math.pow(N, 2)-1-i, (int)Math.pow(N, 2)+1);
		}
	}
	// ��������� ������� N-��-N, � ���� ������������� �ᒺ����� 
	
	
	public int getOpenedCount(){
		return openCount;
		}
	// ������ � ��������� ������� �������� ������
	
	
	public void open(int i){
		openCount++;
		if(i%N!=0&&isOpened(i-1)){
			netElements.union(i, i-1);
		}
		if(i%(N-1)!=0&&isOpened(i+1)){
			netElements.union(i, i+1);
		}
		if(i>(N-1)&&isOpened(i-N)){
			netElements.union(i, i-N);
		}
		if(i<(Math.pow(N, 2)-N)&&isOpened(i+N)){
			netElements.union(i, i+N);
		}
		opentruth[i]=true;
	} 
	// ������� �ᒺ�� i ���� �� �� �� �������� 
	
	
	public boolean isOpened(int i){
		if(opentruth[i])return true;
		return false;
		} 
	// �� �������� �ᒺ�� i? 
	
	
	public boolean percolates(){
		if(netElements.connected((int)Math.pow(N, 2), (int)Math.pow(N, 2)+1))return true;
		return false;
		}
	// �� ������ �������? 
}