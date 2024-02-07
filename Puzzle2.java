import java.util.Scanner;
class Puzzle2
{
    static int x[][] = new int[4][4],row,column;
    static char ch;
    static boolean tag = true;
    void display()
    {
        System.out.println("********************************");
        for(int i = 0;i<=3;i++)
        {
            System.out.print("\t");
            for(int j = 0;j<=3;j++)
            {
                if((i==row)&&(j==column))
                    System.out.print("|"+(char)x[i][j]+(char)x[i][j]+"| ");
                else
                    System.out.print("|"+String.format("%02d",x[i][j])+"| ");
            }
            System.out.println();
        }
        System.out.println("********************************");
    }

    void define()
    {
        int a;
        boolean b[] = new boolean [15];
        row = (int)(Math.random() * 4);
        column = (int)(Math.random() * 4);
        for(int i = 0;i<=3;i++)
        {
            for(int j = 0;j<=3;j++)
            {
                if((i==row)&&(j==column))
                {
                    x[i][j] = (int)' ';
                    continue;
                }
                a = (int)((Math.random()* 15) + 1);
                while(b[a-1]==true)
                    a = (int)((Math.random()* 15) + 1);
                x[i][j] = a;
                b[a-1] = true;
            }
        }
    }

    void shift()
    {
        if(ch=='s')
        {
            if(row!=0)
            {    
                x[row][column] = x[row-1][column];
                row--;
            }
        }
        else if(ch=='w')
        {
            if(row!=3)
            {
                x[row][column] = x[row+1][column];
                row++;
            }
        }
        else if(ch=='d')
        {
            if(column!=0)
            {
                x[row][column] = x[row][column-1];
                column--;
            }
        }
        else if(ch=='a')
        {
            if(column!=3)
            {
                x[row][column] = x[row][column+1];
                column++;
            }
        }
        x[row][column] = (int)' ';
    }

    boolean answer()
    {
        if((x[0][0]==1)&&(x[0][1]==2)&&(x[0][2]==3)&&(x[0][3]==4)&&(x[1][0]==5)&&(x[1][1]==6)&&(x[1][2]==7)&&(x[1][3]==8)&&(x[2][0]==9)&&(x[2][1]==10)
        &&(x[2][2]==11)&&(x[2][3]==12)&&(x[3][0]==13)&&(x[3][1]==14)&&(x[3][2]==15))
            return true;
        return false;
    }

    void cheat()
    {
        int r1,c1,r2,c2,temp;
        System.out.println("________________________________");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("DO NOT SWAP PLACES WITH BLANK");
        Scanner sc = new Scanner(System.in);
        System.out.print("\nRow 1: ");
        r1 = sc.nextInt()-1;
        System.out.print("\nColumn 1: ");
        c1 = sc.nextInt()-1;
        System.out.print("\nRow 2: ");
        r2 = sc.nextInt()-1;
        System.out.print("\nColumn 2: ");
        c2 = sc.nextInt()-1;
        System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        temp = x[r1][c1];
        x[r1][c1] = x[r2][c2];
        x[r2][c2] = temp;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Puzzle2 ob = new Puzzle2();
        System.out.println("--------------------------------");
        System.out.println("Press 'w' for UP\nPress 's' for DOWN\nPress 'a' for LEFT\nPress 'd' for RIGHT\nPress 'e' to RESHUFFLE\nPress 'q' to QUIT");
        System.out.println("--------------------------------");
        ob.define();
        while(ob.answer()==false)
        {
            ob.display();
            ch = sc.next().charAt(0);
            if(ch=='q')
                break;
            if(ch=='e')
            {
                ob.define();
                continue;
            }
            if(ch=='*')
                ob.cheat();
            ob.shift();
        }
        if(ch!='q')
        {
            ob.display();
            System.out.println("--------------------------------\n------------You WIN!------------\n--------------------------------");
        }
        System.out.println("--------------------------------");
        System.out.println("Press 'e' to play AGAIN\nPress 'q' to EXIT");
        System.out.println("--------------------------------");
        if(sc.next().charAt(0)=='e')
        {
            ob.main(null);
        }
        if(tag==true)
        {    System.out.println("--------------------------------\n-----------Thank You!-----------\n--------------------------------");
            tag = false;
        }
    }
}