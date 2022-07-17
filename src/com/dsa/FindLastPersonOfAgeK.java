package com.dsa;
public class FindLastPersonOfAgeK {
  public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> ages = new ArrayList<Integer>();
        List<String> people = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            ages.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            people.add(sc.next());
        }
        String ans = findLastPersonOfAgeK(ages, people, k);
        System.out.println(ans);
        sc.close();
    }

    static String findLastPersonOfAgeK(List<Integer> ages, List<String> people, int k){
        LinkedHashMap<String, Integer> personAgeMap = new LinkedHashMap<>();
        List<String> personNameList = new ArrayList<>();
        for(int i =0; i<people.size(); i++){
            personAgeMap.put(people.get(i), ages.get(i));
        }
        int count = 0;
        for(int age: ages){
            if(age == k){
                count += 1;
            }
        }
        if(count == 0){
            return ("Not found");
        }
        for (Map.Entry<String, Integer>
                entry : personAgeMap.entrySet()){
            if(count == 1 && entry.getValue() == k){
                return entry.getKey();

            }
            else if(count>1 && entry.getValue() == k){
                personNameList.add(entry.getKey());
            }
        }
        return personNameList.get(personNameList.size()-1);
    }
}
