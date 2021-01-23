package com.xps.java.ds.queue;

public class CircularTour {
	
	public static void main(String[] args) {
		
		PetrolPump[] pump = {new PetrolPump(4, 6), 
							 new PetrolPump(6, 5),
							 new PetrolPump(7, 3),
							 new PetrolPump(4, 5)};
		
		System.out.println(findFirstPetrolPump(pump, 4));
		
	}
	
	private static int findFirstPetrolPump(PetrolPump[] pump, int n) {
		
		int firstPumpIndex=0, lastPumpIndex=n-1;
		int i = firstPumpIndex, accessPetrol =0;

		while(i != lastPumpIndex) {
			accessPetrol = canTravelTillNextPetrolPump(pump[i], accessPetrol);
			if (accessPetrol < 0) {
				firstPumpIndex = incrementIndex(firstPumpIndex, n);
				if (i >= n) {
					return -1;
				}
				lastPumpIndex = incrementIndex(lastPumpIndex, n);
				i = firstPumpIndex;
				accessPetrol = 0;
			}else {
				i = incrementIndex(i, n);
			}
		}
		return firstPumpIndex;
	}
	
	private static int incrementIndex(int firstIndex, int n) {
		return (firstIndex+1)%n;
	}
	
	private static int canTravelTillNextPetrolPump(PetrolPump pump, int accessPetrol) {
		return (pump.petrol + accessPetrol) - pump.distance;
	}
	
	static class PetrolPump {
		int petrol;
		int distance;
		
		public PetrolPump(int petrol, int distance) {
			super();
			this.petrol = petrol;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "PetrolPump [petrol=" + petrol + ", distance=" + distance + "]";
		}
	}
}
