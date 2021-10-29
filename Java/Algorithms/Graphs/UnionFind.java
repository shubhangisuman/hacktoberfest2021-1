/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Pair{
    char key;
    char value;
    Pair(char key,char value){
        this.key = key;
        this.value = value;
    }
}
class UnionFind{
    //int[] arr;
    HashMap<Character,Character> map;
    int n;
    UnionFind(List<Character> list){
        this.n = list.size();
        map = new HashMap<>(n);
        for(int i=0;i<n;i++)
            map.put(list.get(i),list.get(i));
    }
    Character root(Character p){
        if(p==map.get(p))
            return p;
        return root(map.get(p));
    }
    void union(Character p, Character q){
        Character root1 = root(p);
        Character root2 = root(q);
        if(!isConnected(root1,root2)){
            map.put(root1,root2);
            n--;
        }
    }
    int getNumberOfComponents(){
        return n;
    }
    boolean isConnected(Character p, Character q){
        return root(p)==root(q);
    }
}

class Main {
	public static void main (String[] args) {
		String s1 = "abcc";//abccc
		Set<Character> set1 = new HashSet<>();
		for(int i=0;i<s1.length();i++)
		    set1.add(s1.charAt(i));
		int size = set1.size();
		List<Pair> list =new ArrayList<>(); //Internally use map

		list.add(new Pair('b','c')); //b,c
		list.add(new Pair('a','b')); //a,b
// 		list.add(new Pair('b'-'a','c'-'a')); //b,c
// 		list.add(new Pair('a'-'a','d'-'a')); //a,b
		for(int i=0;i<2;i++)
		    System.out.println(list.get(i).key+"     "+list.get(i).value);

		UnionFind unionfind = new UnionFind(new ArrayList<>(set1));
		int n = size; //number of components
		for(int i=0;i<list.size();i++){
		    char p = list.get(i).key;
		    char q = list.get(i).value;
		  //  if(!unionfind.isConnected(p,q)){
		        unionfind.union(p,q);
		      //  n--;
		  //  }
		}
		System.out.println(unionfind.getNumberOfComponents()==1);
	}
}