package A;

/**
 * Created by nhs09 on 2016-10-10.
 */

interface findText {
    void findCodon(String acgtSequence, String codon); //codon 찾기


}

class findTextExecute implements findText {


    @Override
    public void findCodon(String acgtSequence, String codon) {
        int duplicationIndex = 0; //찾았던 글자 마지막 index 값 저장 (중복 찾기 방지)
        if (acgtSequence.length() - codon.length() != 0) {
            //글자수가 찾는 글자수랑 일치하지 않을 때
            for (int i = 0; i < acgtSequence.length() - codon.length(); i++) {//codon 찾기

                int confirmCnt = 1; //찾는 글자랑 일치하는 갯수
                if (codon.charAt(0) == acgtSequence.charAt(i)) {
                    //첫글자와 같은 경우이면

                    while (confirmCnt < codon.length()) {
                        //codon 길이만큼 반복한다.

                        //if(acgtSequence.charAt())
                        if (acgtSequence.charAt(confirmCnt + i) == codon.charAt(confirmCnt)) {
                            //첫글자 이후에 글자가 같은지 확인
                            // System.out.println(confirmCnt++);
                            confirmCnt++;
                            if (confirmCnt == codon.length()) {
                                //첫 글자 index 값이  찾는 글자 수 길이 안에 똑같은거 있는지 확인과 confirmCnt 글자 수 일치 숫자랑 찾는 글자수 길이가 같으면
                                if (i == 0) {//찾은 글자가 첫번째일때
                                    System.out.println(i);
                                    duplicationIndex = i;
                                } else if (i - duplicationIndex > codon.length() - 1) {
                                    System.out.println(i);
                                    duplicationIndex = i;
                                }
                            }
                        } else {
                            //같지 않으면
                            break;
                        }
                    }
                }

            }
        } else {
            //찾는 글자수랑 주어진 글자수가 일치 할 때
            for (int i = 0; i < acgtSequence.length(); i++) {//codon 찾기

                int confirmCnt = 1; //찾는 글자랑 일치하는 갯수
                if (codon.charAt(0) == acgtSequence.charAt(i)) {
                    //첫글자와 같은 경우이면
                    //System.out.println("첫글자 시작 위치 : "+ i);
                    while (confirmCnt < codon.length()) {
                        //codon 길이만큼 반복한다.

                        //if(acgtSequence.charAt())
                        if (acgtSequence.charAt(confirmCnt + i) == codon.charAt(confirmCnt)) {
                            //첫글자 이후에 글자가 같은지 확인
                            // System.out.println(confirmCnt++);
                            confirmCnt++;
                            if (confirmCnt == codon.length()) {
                                //첫 글자 index 값이  찾는 글자 수 길이 안에 똑같은거 있는지 확인과 confirmCnt 글자 수 일치 숫자랑 찾는 글자수 길이가 같으면
                                System.out.println(i);
                                duplicationIndex = i;
                            }
                        } else {
                            //같지 않으면
                            break;
                        }
                    }
                }
            }
        }
    }
}

public class HanCom2 {
    public static void main(String[] args) {


        String ACGT = "ACCGGCCGAGACAGCGAGCATATGCCGCCGAGACAGGCCGGACCGGCCGAGA";
        String codon = "GCCG";


        // String ACGT = "GOOGLEhihihi";
        // String codon = "GOOGLE";
        findTextExecute sample = new findTextExecute();
        sample.findCodon(ACGT, codon);
    }
}
