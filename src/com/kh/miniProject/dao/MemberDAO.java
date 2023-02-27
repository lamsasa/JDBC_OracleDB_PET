package com.kh.miniProject.dao;
import com.kh.miniProject.util.Common;
import com.kh.miniProject.vo.MemberVO;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<MemberVO> allMemberSelect() {
        List<MemberVO> list = new ArrayList<>();
        try {
           conn = Common.getConnection();
           stmt = conn.createStatement();
           String sql = "SELECT * FROM MEMBER ORDER BY USER_ID";
           rs = stmt.executeQuery(sql);

           while(rs.next()) {
               String id = rs.getString("USER_ID");
               String pw = rs.getString("USER_PW");
               String name = rs.getString("USER_NAME");
               String mail = rs.getString("EMAIL");
               String phone = rs.getString("PHONE");
               MemberVO vo = new MemberVO(id,pw,name,mail,phone);
               list.add(vo);
           }
           Common.close(rs);
           Common.close(stmt);
           Common.close(conn);

        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void memberSelectPrint(List<MemberVO> list) {
        for(MemberVO e : list) {
            System.out.println("ID : " + e.getId());
            System.out.println("비밀번호 : " + e.getPw());
            System.out.println("이름 : " + e.getName());
            System.out.println("메일 : " + e.getMail());
            System.out.println("핸드폰 : " + e.getPhone());
            System.out.println("--------------------------");
        }
    }

    public List<MemberVO> specificMemberSelect() {
        List<MemberVO> list = new ArrayList<>();
        System.out.print("ID 입력 : ");
        String id = sc.next();
        String sql = "SELECT * FROM MEMBER WHERE USER_ID = " + "'" + id + "'";
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                String pw = rs.getString("USER_PW");
                String name = rs.getString("USER_NAME");
                String mail = rs.getString("EMAIL");
                String phone = rs.getString("PHONE");
                MemberVO vo = new MemberVO(id,pw,name,mail,phone);
                list.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}