#include <stdio.h>

struct person{
    int age;

    void (*set)(struct person *,int);
    int (*get)(struct person *);
};

void setAge(struct person * inst,int age){
    inst->age=age;
}

int getAge(struct person * inst){
    return inst->age;
}

void main(){

    struct person p1;
    p1.set=setAge;
    p1.get=getAge;
    p1.set(&p1,18);
    printf("Age is %d",p1.get(&p1));
}