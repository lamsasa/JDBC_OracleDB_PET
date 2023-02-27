package com.kh.miniProject;

import com.kh.miniProject.dao.MemberDAO;
import com.kh.miniProject.vo.MemberVO;

import java.util.List;
import java.util.Scanner;

public class JdbcMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberDAO dao = new MemberDAO();
        while(true) {
            System.out.println("[고양이 집사 커뮤니티 test]");
            System.out.println("");
            System.out.println("메뉴를 선택하세요.");
            System.out.print("[1]전체 회원정보 조회 [2] 특정 아이디 회원정보 [3] 종료 : ");
            int sel = sc.nextInt();
            switch(sel) {
                case 1 :
                    List<MemberVO> list = dao.allMemberSelect();
                    dao.memberSelectPrint(list);
                    break;
                case 2 :
                    list = dao.specificMemberSelect();
                    dao.memberSelectPrint(list);

                    break;
                case 3 :
                    System.out.println("종료합니다.");
                    return;
            }
        }
    }
}
