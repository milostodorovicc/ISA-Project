package com.project.isa.component;

public class MyMutableData {
        private int granica1;
        private int granica2;
        private int granica3;
        private int granica4;

        public MyMutableData(int granica1, int granica2, int granica3, int granica4) {
            this.granica1 = granica1;
            this.granica2 = granica2;
            this.granica3 = granica3;
            this.granica4 = granica4;
        }

    public int getGranica1() {
        return granica1;
    }

    public void setGranica1(int granica1) {
        this.granica1 = granica1;
    }

    public int getGranica2() {
        return granica2;
    }

    public void setGranica2(int granica2) {
        this.granica2 = granica2;
    }

    public int getGranica3() {
        return granica3;
    }

    public void setGranica3(int granica3) {
        this.granica3 = granica3;
    }

    public int getGranica4() {
        return granica4;
    }

    public void setGranica4(int granica4) {
        this.granica4 = granica4;
    }
}

