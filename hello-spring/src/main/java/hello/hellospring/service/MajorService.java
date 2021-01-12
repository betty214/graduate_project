package hello.hellospring.service;

import hello.hellospring.domain.Majors;
import hello.hellospring.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.*;

@Transactional
public class MajorService {
    private final MajorRepository majorRepository;
    public MajorService(MajorRepository majorRepository){
        this.majorRepository=majorRepository;
    }
    public static ArrayList<String> table_name = new ArrayList<String>();
    public static ArrayList<String> table_time = new ArrayList<String>();
    public static ArrayList<String> table_professor = new ArrayList<String>();
    public static String[][][] real_table = new String[101][101][101];
    public static HashMap<String, Integer> duplicate_count = new HashMap<String, Integer>();
    public static int day1 = 100;
    public static int day2 = 100;
    public static int time1 = 100;
    public static int time2 = 100;
    public static int day3 = 100;
    public static int time3 = 100;
    public static String[][] name_table = new String[100][6];

    public static void table_maker(String[] semi_table, int table2_number) {
        int flag=0;
        for (int i = 0; i < 6; i++) {
            if (semi_table[i].length() == 2) {
                day1 = (Integer.parseInt(semi_table[i].substring(0, 1)) - 1);
                time1 = (Integer.parseInt(semi_table[i].substring(1, 2)) - 1);
                real_table[day1][time1][table2_number] = Integer.toString(i);
            } else if (semi_table[i].length() == 4) {
                day1 = (Integer.parseInt(semi_table[i].substring(0, 1)) - 1);
                time1 = (Integer.parseInt(semi_table[i].substring(1, 2)) - 1);
                day2 = (Integer.parseInt(semi_table[i].substring(2, 3)) - 1);
                time2 = (Integer.parseInt(semi_table[i].substring(3, 4)) - 1);
                real_table[day1][time1][table2_number] = Integer.toString(i);
                real_table[day2][time2][table2_number] = Integer.toString(i);
            } else if (semi_table[i].length() == 6) {
                day1 = (Integer.parseInt(semi_table[i].substring(0, 1)) - 1);
                time1 = (Integer.parseInt(semi_table[i].substring(1, 2)) - 1);
                day2 = (Integer.parseInt(semi_table[i].substring(2, 3)) - 1);
                time2 = (Integer.parseInt(semi_table[i].substring(3, 4)) - 1);
                day3 = (Integer.parseInt(semi_table[i].substring(4, 5)) - 1);
                time3 = (Integer.parseInt(semi_table[i].substring(5, 6)) - 1);
                real_table[day1][time1][table2_number] = Integer.toString(i);
                real_table[day2][time2][table2_number] = Integer.toString(i);
                real_table[day3][time3][table2_number] = Integer.toString(i);
            }
        }
    }

    public List<Majors> findMajor() {
        for(Majors value : majorRepository.findByRT(32)) {
            table_name.add(value.getMajor_name());
            table_time.add(Integer.toString(value.getThis_time()));
            table_professor.add(value.getProfessor_name());
        }
        for (int m = 0; m < table_name.size(); m++) { // ArrayList 만큼 반복
            if(table_name.get(m)!=null) {
                if (duplicate_count.containsKey(table_name.get(m))) { // HashMap 내부에 이미 key 값이 존재하는지 확인
                    duplicate_count.put(table_name.get(m), duplicate_count.get(table_name.get(m)) + 1); // key가 이미 있다면
                    // value에 +1
                } else { // key값이 존재하지 않으면
                    duplicate_count.put(table_name.get(m), 1); // key 값을 생성후 value를 1로 초기화
                }
            }
        }
        int[] bunban = new int[6];
        String[][] created_table = new String[100][6];
        int[][] bunban_table = new int[100][6];
        String[][] pname_table = new String[100][6];
        int q = 0;
        for (Map.Entry<String, Integer> entry : duplicate_count.entrySet()) {
            bunban[q] = entry.getValue();
            q++;
        }
        q = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k <3; k++) {
                    for (int l = 0; l < 1; l++) {
                        for (int m = 0; m < 1; m++) {
                            for (int n = 0; n < 1; n++) {
                                created_table[q][0] = table_time.get(7 + i);
                                name_table[q][0] = table_name.get(7 + i);
                                bunban_table[q][0] = (1 + i);
                                pname_table[q][0] = table_professor.get(7 + i);
                                created_table[q][1] = table_time.get(5 + j);
                                name_table[q][1] = table_name.get(5 + j);
                                bunban_table[q][1] = (1 + j);
                                pname_table[q][1] = table_professor.get(5 + j);
                                created_table[q][2] = table_time.get(1 + k);
                                name_table[q][2] = table_name.get(1 + k);
                                bunban_table[q][2] = (1 + k);
                                pname_table[q][2] = table_professor.get(1 + k);
                                created_table[q][3] = table_time.get(l);
                                name_table[q][3] = table_name.get(l);
                                bunban_table[q][3] = (1 + l);
                                pname_table[q][3] = table_professor.get(l);
                                created_table[q][4] = table_time.get(4 + m);
                                name_table[q][4] = table_name.get(4 + m);
                                bunban_table[q][4] = (1 + m);
                                pname_table[q][4] = table_professor.get(4 + m);
                                created_table[q][5] = table_time.get(6 + n);
                                name_table[q][5] = table_name.get(6 + n);
                                bunban_table[q][5] = (1 + n);
                                pname_table[q][5] = table_professor.get(6 + n);
                                q++;
                            }
                        }
                    }
                }
            }
        }
        String day = "";
        String course_name = "";
        String prof_name = "";
        table_maker(created_table[0], 0);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 7; j++) {
                    if (real_table[i][j][0] != null) {
                        if (i == 0) {
                            day = "월";
                        } else if (i == 1) {
                            day = "화";
                        } else if (i == 2) {
                            day = "수";
                        } else if (i == 3) {
                            day = "목";
                        } else if (i == 4) {
                            day = "금";
                        }
                        int bun = 0;
                        int n = Integer.parseInt(real_table[i][j][0]);
                        course_name = name_table[0][n];
                        bun = bunban_table[0][n];
                        prof_name = pname_table[0][n];
                        System.out.println(1+" "+day+" "+(j+1)+" "+course_name+" "+bun+" "+prof_name);
                    }
                }
            }

        return majorRepository.findByRT(32);
    }
}
