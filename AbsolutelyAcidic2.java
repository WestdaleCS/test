package ccc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AbsolutelyAcidic2 {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
		try {
			int n = Integer.parseInt(in.readLine());
			int [] info = new int [1000];

			for(int i = 0 ; i < n ; i ++) {
				info[Integer.parseInt(in.readLine())-1]++;
			}

			int most = 0;
			int smost = 0;

			ArrayList <Integer> m = new ArrayList<Integer>();
			ArrayList <Integer> sm = new ArrayList<Integer>();

			for(int i = 0 ; i < 1000 ; i ++) {
				if(info[i]!=0) {
					if(info[i]>most) {
						smost = most;
						sm.clear();
						sm.addAll(m);
						most = info[i];
						m.clear();
						m.add(i);
					}else if (info[i] == most) {
						m.add(i);
					}else if(info[i]>smost) {
						smost = info[i];
						sm.clear();
						sm.add(i);
					}else if (info[i]== smost) {
						sm.add(i);
					}
				}
			}
			int ans = 0;
			if(m.size()>1) {
				Collections.sort(m);
				ans = Math.abs(m.get(0)-m.get(m.size()-1));
			}else {
				Collections.sort(sm);
				Collections.sort(m);
				ans =  Math.max(Math.abs(m.get(m.size()-1)-sm.get(0)),Math.abs(m.get(0)-sm.get(sm.size()-1)));
			}
			System.out.println(ans);

		}catch(Exception e) {

		}
	}
}
