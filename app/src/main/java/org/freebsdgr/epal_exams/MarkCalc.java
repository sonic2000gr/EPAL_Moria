package org.freebsdgr.epal_exams;

public class MarkCalc {
    private int nea;
    private int mathimatika;
    private int eidikothta1;
    private int eidikothta2;
    private int eidiko;

    MarkCalc() {
        nea = mathimatika = eidikothta1 = eidikothta2 = eidiko = 0;
    }

    MarkCalc(int nea,  int mathimatika,  int eidikothta1,  int eidikothta2, int eidiko) {
        if (nea>=0 && nea<=200 && mathimatika>=0 && mathimatika<=200 && eidikothta1>=0
                && eidikothta1<=200 && eidikothta2>=0 && eidikothta2<=200) {
            this.nea = nea;
            this.mathimatika = mathimatika;
            this.eidikothta1 = eidikothta1;
            this.eidikothta2 = eidikothta2;
            this.eidiko = eidiko;
        } else {
            this.mathimatika = 0;
            this.nea = 0;
            this.eidikothta1 = 0;
            this.eidikothta2 = 0;
            this.eidiko = 0;
        }
    }

    public boolean setGrades(int nea, int mathimatika, int eidikothta1, int eidikothta2, int eidiko) {
        if (nea>=0 && nea<=200 && mathimatika>=0 && mathimatika<=200 && eidikothta1>=0
                && eidikothta1<=200 && eidikothta2>=0 && eidikothta2<=200 && eidiko>=0 && eidiko<=200) {
            this.nea = nea;
            this.mathimatika = mathimatika;
            this.eidikothta1 = eidikothta1;
            this.eidikothta2 = eidikothta2;
            this.eidiko = eidiko;
            return true;
        } else
            return false;
    }

    public int getGradeNea() {
        return nea;
    }

    public int getMathimatika() {
        return mathimatika;
    }

    public int getEidikothta1() {
        return eidikothta1;
    }

    public int getEidikothta2() {
        return eidikothta2;
    }

    public int getEidiko() { return eidiko; }

    public boolean setGradeNea(int nea) {
        if (nea>=0 && nea<=200)
            this.nea = nea;
        else
            return false;
        return true;
    }

    public boolean setGradeMathimatika(int mathimatika) {
        if (mathimatika>=0 && mathimatika<=200)
            this.mathimatika = mathimatika;
        else
            return false;
        return true;
    }

    public boolean setGradeEidikothta1(int eidikothta1) {
        if (eidikothta1>=0 && eidikothta1<=200)
            this.eidikothta1 = eidikothta1;
        else
            return false;
        return true;
    }

    public boolean setGradeEidikothta2(int eidikothta2) {
        if (eidikothta2>=0 && eidikothta2<=200)
            this.eidikothta2 = eidikothta2;
        else
            return false;
        return true;
    }

    public boolean setEidiko (int eidiko) {
        if (eidiko>=0 && eidiko<=200)
            this.eidiko = eidiko;
        else
            return false;
        return true;
    }

    public float calcResult() {
        return nea * 15f + mathimatika * 15f  + eidikothta1*35f + eidikothta2 * 35f + eidiko * 20f;
    }
}
