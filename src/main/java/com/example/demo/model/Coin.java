package com.example.demo.model;

public enum Coin {
    V1(1), V2(2),  V3(5), V4(10);

        private int value;

        Coin(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }

}
