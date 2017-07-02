import java.util.Arrays;

public class RobotControl {
	private Robot r;
	public RobotControl(Robot r){
		this.r = r;
	}

	int h = 2;
	int w = 1; 
	int d = 0;

	int sourceHt = 6;
	int targetHt1 = 0;
	int targetHt2 = 0;
	int targetHt3 = 0;
	int barHt = 3;

	int clearence = 10;

	public void control(int barHeights[], int blockHeights[]){

		/* SECTION ONE */
		clearence = 9;
		
		while ( h < clearence ){
			r.up();
			h++;
		}

		for(int i = 3; i > 0; i--){
			get(); 

			put(i);
		}

		/* SECTION TWO */
		Arrays.sort(barHeights);
		clearence = barHeights[barHeights.length - 1] + 4;

		while ( h < clearence ){
			r.up();
			h++;
		}

		for(int i = 3; i > 0; i--){
			get(); 

			put(i);
		}
	}

	public void get() {

		while ( d > 0 ){
			r.raise();
			d--;
		}

		while ( w < 10 ){
			r.extend();
			w++;
		}

		while ( h - d > sourceHt + 1 ){
			r.lower();
			d++;
		}

		r.pick();
	}

	public void put(int block) {
		int blockHt = block;
		sourceHt -= blockHt;   

		while ( d > 0 ){
			r.raise();
			d--;
		}

		int targetWidth = block; 
		while ( w > targetWidth){
			r.contract();
			w--;
		}

		while ( h - d - blockHt > targetHt3 + 1 ){
			r.lower();
			d++;
		}

		r.drop();
	}
}
