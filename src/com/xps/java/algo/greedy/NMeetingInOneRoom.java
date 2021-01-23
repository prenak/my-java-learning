package com.xps.java.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// There is one meeting room in a firm. 
// There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.
// What is the maximum number of meetings that can be accommodated in the meeting room?

// 1. S[i] = 1 3 0 5 8 5 
//	  F[i] = 2 4 6 7 9 9
// 2. S[i] = 75250 50074 43659 8931 11273 27545 50879 77924 
//    F[i] = 112960 114515 81825 93424 54316 35533 73383 160252

public class NMeetingInOneRoom {

	public static void main(String[] args) {
//		int n = 6;
//		int[] startTime = {1, 3, 0, 5, 8, 5};
//		int[] endTime = {2, 4, 6, 7, 9, 9};
		
		int n = 8;
		int[] startTime = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
		int[] endTime = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252};
		
		List<Meeting> meetings = getMeetings(n, startTime, endTime);
		findMaxMeetings(meetings);
	}
	
	private static List<Meeting> getMeetings(int n, int[] startTime, int[] endTime){
		List<Meeting> meetings = new ArrayList<>();
		NMeetingInOneRoom mr = new NMeetingInOneRoom();
		for (int i=0; i<n; i++) {
			Meeting m = mr.new Meeting(i, startTime[i], endTime[i]);
			meetings.add(m);
		}
		return meetings;
	}
	
	private static void findMaxMeetings(List<Meeting> meetings) {
		Comparator<Meeting> endTimeComparator = Comparator.comparing(Meeting::getEndTime);
		Collections.sort(meetings, endTimeComparator);
		
		System.out.println("Sorted meetings: " + meetings);
		
		Meeting m = meetings.get(0);
		System.out.println(m);
		
		for (int i=1; i<meetings.size(); i++) {
			Meeting nextM = meetings.get(i);
			if (m.getEndTime() <= nextM.getStartTime()) {
				m = nextM;
				System.out.println(m);
			}
		}
	}
	
	class Meeting {
		private int index;
		private int startTime;
		private int endTime;
		
		public Meeting(int index, int startTime, int endTime) {
			super();
			this.index = index;
			this.startTime = startTime;
			this.endTime = endTime;
		}
		public int getIndex() {
			return index;
		}
		public int getStartTime() {
			return startTime;
		}
		public int getEndTime() {
			return endTime;
		}
		
		@Override
		public String toString() {
			return "Meeting [index=" + index + ", startTime=" + startTime + ", endTime=" + endTime + "]";
		}
	}

}
