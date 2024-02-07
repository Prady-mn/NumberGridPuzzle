#!/usr/bin/env python
# coding: utf-8

# In[ ]:

#If ModuleNotFoundError: No module named 'IPython'
## pip install ipython

from IPython.display import clear_output;
import math;
import random;

num = 3;
frame = [[0 for i in range(num)] for j in range(num)];
row = 0;
col = 0;
valid_input = ('w','a','s','d','q','r');
c = 'x';
def create():
    global row,col;
    temp = [];
    for i in range(num):
        for j in range(num):
            x = random.randint(1,num**2);
            while x in temp:
                x = random.randint(1,num**2);
            temp.append(x);
            frame[i][j] = x;
            if(x == num**2):
                row = i;
                col = j;
                frame[i][j] = '@';
        
def move():
    c = ' ';
    print("---------------------------------------------");
    print("---------------------------------------------");
    print("W to shift UP");
    print("A to shift LEFT");
    print("S to shift DOWN");
    print("D to shift RIGHT");
    print("R to RESTART");
    print("Q to QUIT/EXIT");
    print("---------------------------------------------");
    print("ENTER a VALID LETTER to BEGIN");
    print("---------------------------------------------");
    print("---------------------------------------------");
    while(c != 'q'):
        c = input("Move: ")[0];
        if(c not in valid_input):
            print("INVALID INPUT");
            continue;
        #input for exit
        if(c == 'q'):
            
            break;
        elif(c == 'w'):
            move_up();
        elif(c == 's'):
            move_down();
        elif(c == 'a'):
            move_left();
        elif(c == 'd'):
            move_right();
        elif(c == 'r'):
            restart();
        display();
        if(win()):
            print("VICTORY!!!");
            break;
        

def move_up():
    global row,col;
    if(row != (num-1)):
        frame[row][col] = frame[row+1][col];
        row+=1;
        frame[row][col] = '@';
        

def move_down():
    global row,col;
    if(row != 0):
        frame[row][col] = frame[row-1][col];
        row-=1;
        frame[row][col] = '@';

def move_right():
    global row,col;
    if(col != 0):
        frame[row][col] = frame[row][col-1];
        col-=1;
        frame[row][col] = '@';

def move_left():
    global row,col;
    if(col != (num-1)):
        frame[row][col] = frame[row][col+1];
        col+=1;
        frame[row][col] = '@';
def display():
    clear_output(wait=False);
    print("---------------------------------------------");
    print("---------------------------------------------");
    print("---------------------------------------------");
    for rows in frame:
        for x in rows:
            print(x,"  ",end =" ");
        print();
    print("---------------------------------------------");
    print("---------------------------------------------");
    print("---------------------------------------------");
def win():
    count = 1;
    for rows in frame:
        for x in rows:
            if(count == num**2):
                return True;
            if(x != count):
                return False;
            count += 1;
    return True;
def restart():
    create();
    move();

create();
move();

