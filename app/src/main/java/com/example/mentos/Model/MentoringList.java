package com.example.mentos.Model;

import java.util.ArrayList;
import java.util.List;

public class MentoringList {
    private List<Mentoring> mMentorings = new ArrayList<>();
    private Mentoring mentoring;

    public MentoringList() {
    }

    public MentoringList(List<Mentoring> mMentorings) {
        this.mMentorings = mMentorings;
    }

    public List<Mentoring> getmMentorings() {
        return mMentorings;
    }

    public void setmMentorings(List<Mentoring> mMentorings) {
        this.mMentorings = mMentorings;
    }

    public  void settings(){
        //1
        mentoring = new Mentoring();
        mentoring.setTitle("다문화 및 탈북학생 멘토링");
        mentoring.setStart("20190320");
        mentoring.setEnd("20200210");
        mentoring.setUsername("부산대학교");
        mentoring.setMetoring("기초 학습 지도, 문화 체험 활동, 정서 지원");
        mentoring.setContents("멘토 1 : 멘티 1 결연, 멘티 희망 교과목 기초 및 기본 학습지도\n" +
                "1학기 1회 단체 현장체험학습 프로그램 진행\n" +
                "학대아동 상담 및 정서지원 활동\n" +
                "사회적 배려 지도");
        mentoring.setUrl("http://nanum.pusan.ac.kr/sub/Intro/mentoHistory.html?id=14");
        mMentorings.add(mentoring);

        //2
        mentoring = new Mentoring();
        mentoring.setTitle("거점중학교성사업 대학생 멘토링");
        mentoring.setStart("20190320");
        mentoring.setEnd("20190210");
        mentoring.setUsername("부산대학교");
        mentoring.setMetoring("기초 학습 지도, 문화 체험, 캠프, 정서 지원");
        mentoring.setContents("멘토 1 : 멘토 3 결연, 1회 2~3시간 권장\n" +
                "문화 체험 권장 활동 : 부산대학교 캠퍼스 투어, 박물관 및 미술관, 건전 공연\n" +
                "캠프 : 의무 참여 및 불참 시 4시간 학습지도로 대체\n" +
                "정서지원 : 청소년기 고민 상담, 진로 및 진학 지도");
        mentoring.setUrl("http://nanum.pusan.ac.kr/sub/Intro/mentoHistory.html?id=01");
        mMentorings.add(mentoring);

        //3
        mentoring = new Mentoring();
        mentoring.setTitle("기장희망꿈나무 멘토링");
        mentoring.setStart("20190320");
        mentoring.setEnd("20200210");
        mentoring.setUsername("부산대학교");
        mentoring.setMetoring("기초 학습 지도, 문화 체험, 캠프, 정서 지원");
        mentoring.setContents("멘토 1 : 멘토 3 결연, 1회 2~3시간 권장\n" +
                "문화 체험 권장 활동 : 부산대학교 캠퍼스 투어, 박물관 및 미술관, 건전 공연\n" +
                "캠프 : 의무 참여 및 불참 시 4시간 학습지도로 대체\n" +
                "정서지원 : 청소년기 고민 상담, 진로 및 진학 지도");
        mentoring.setUrl("http://nanum.pusan.ac.kr/sub/Intro/mentoHistory.html?id=02");
        mMentorings.add(mentoring);

        //4
        mentoring = new Mentoring();
        mentoring.setTitle("3-DAYS프로그램 멘토링");
        mentoring.setStart("20190511");
        mentoring.setEnd("20200205");
        mentoring.setUsername("부산대학교");
        mentoring.setMetoring("교육 기부, 캠프");
        mentoring.setContents("1개의 팀 당 인솔자 1명(석사수료 이상 학위 소지자), 학부생 7명 이상으로 구성\n" +
                "인솔자의 의무 : 계획서 마련 및 토요일 프로그램 참여\n" +
                "팀별 지원금 : 3,000천원 ~ 5,000천원\n" +
                "지원금 사용 : 교육재료비, 교재제작, 교통비, 식비, 숙박비");
        mentoring.setUrl("http://nanum.pusan.ac.kr/sub/Intro/mentoHistory.html?id=05");
        mMentorings.add(mentoring);

        //5
        mentoring = new Mentoring();
        mentoring.setTitle("HUG TOGETHER 멘토링");
        mentoring.setStart("20190407");
        mentoring.setEnd("20191228");
        mentoring.setUsername("부산대학교");
        mentoring.setMetoring("학습 지도");
        mentoring.setContents("멘토링 진행 시간 : 주 2회 이상. 1회 2시간 이상 활동\n" +
                "멘토링 진행 장소 : 멘티 가정\n" +
                "멘토링 진행 내용 : 멘티 희망 과목\n" +
                "과목별 총원 20명(수학 10명, 영어 4명, 과학 3명, 국어 3명)");
        mentoring.setUrl("http://nanum.pusan.ac.kr/sub/Intro/mentoHistory.html?id=09");
        mMentorings.add(mentoring);

        //6
        mentoring = new Mentoring();
        mentoring.setTitle("다꿈 멘토링");
        mentoring.setStart("20190318");
        mentoring.setEnd("20200210");
        mentoring.setUsername("부산대학교");
        mentoring.setMetoring("창의성 및 감성 확대, 이중언어 교육");
        mentoring.setContents("고교 및 대학 진학을 앞둔 중.고등학교 다문화 탈북학생의 진로 및 진학 지원을 위해\n" +
                "부산대학교 93개 전공 중 창의성과 예술 감수성을 키우는 예.체틍 및 4차 산업 혁명 관련 등에\n" +
                "관심을 관심을 둔 다문화/탈북 학생과 부모나라 언어에 관심을 가지고, 언어능력 향상에\n" +
                "관심을 가진 다문화/탈북 학생 및 외국인 학생을 인재로 성장시키기 위한 프로그램.");
        mentoring.setUrl("http://nanum.pusan.ac.kr/sub/Intro/mentoHistory.html?id=11");
        mMentorings.add(mentoring);

        //7
        mentoring = new Mentoring();
        mentoring.setTitle("마음건강 멘토링");
        mentoring.setStart("20190318");
        mentoring.setEnd("20200210");
        mentoring.setUsername("부산대학교");
        mentoring.setMetoring("학습지도, 정서지원");
        mentoring.setContents("멘토 1 : 멘티 1 결연\n" +
                "멘티 희망 교과목 기초 및 기본 학습 지도(국어, 영어, 수학 등)\n" +
                "정신질환 아동 상담 및 정서지원 활동\n" +
                "일상 환경 개선, 투여 약물 관리 등 생활지도\n" +
                "교육기관 동생, 학습 및 인성지도");
        mentoring.setUrl("http://nanum.pusan.ac.kr/sub/Intro/mentoHistory.html?id=08");
        mMentorings.add(mentoring);

        //8
        mentoring = new Mentoring();
        mentoring.setTitle("HI-효원 멘토링");
        mentoring.setStart("20190318");
        mentoring.setEnd("20200211");
        mentoring.setMetoring("학대 피해 아동 대상 정서지원 멘토링");
        mentoring.setContents("멘토 1 : 멘티 1 결연\n" +
                "멘티 희망 교과목 기초 및 기본 학습 지도 (국어, 영어, 수학 등)\n" +
                "현장체험학습 활동 : 대학탐방, 문화체험, 봉사활동 등\n" +
                "1학기 1회 단체 현장체험학습 프로그램 진행\n" +
                "1:1 멘토링을 기본으로 하되, 희망시 형제 및 자매 동반지도 가능\n" +
                "학대아동 상담 및 정서지원 활동\n" +
                "사회적 배려 지도");
        mentoring.setUrl("http://nanum.pusan.ac.kr/sub/Intro/mentoHistory.html?id=07");
        mMentorings.add(mentoring);

        //9
        mentoring = new Mentoring();
        mentoring.setTitle("2019학년도 10차 멘토스쿨");
        mentoring.setStart("20190822");
        mentoring.setEnd("20200830");
        mentoring.setMetoring("2019학년도 10차 멘토스쿨");
        mentoring.setContents("지원방법 : 지역사회기여센터 교육기부 홈페이지에서 접수\n" +
                "문의처 : 지역사회기여센터 510-1247, 3322, 1368\n" +
                "- 기타 주의 사항\n" +
                " 1. 참가신청 전 반드시 개인 경력사항 PASS 입력, 학과 인증받기\n" +
                " 2. 직업 선호도 검사하고, 참가신청시 작성시 결과물 첨부파일로 업로드 하기\n" +
                " 3. 멘토스쿨 이수 후, 멘토링 프로그램 별 멘토 모집 시 참고사항");
        mentoring.setUrl("http://nanum.pusan.ac.kr/sub/notice/noticeDetail.html?id=57");
        mMentorings.add(mentoring);

    }
}
