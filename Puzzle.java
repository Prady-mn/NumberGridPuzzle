import java.util.Scanner;
class Puzzle
{
    static char x[][] = new char[3][3],ch;
    static int row,column;
    static boolean tag = true;
    void display()
    {
        System.out.println("********************************");
        for(int i = 0;i<=2;i++)
        {
            System.out.print("\t");
            for(int j = 0;j<=2;j++)
                System.out.print("|"+x[i][j]+"| ");
            System.out.println();
        }
        System.out.println("********************************");
    }

    void define()
    {
        int a;
        boolean b[] = new boolean [8];
        row = (int)(Math.random() * 3);
        column = (int)(Math.random() * 3);
        for(int i = 0;i<=2;i++)
        {
            for(int j = 0;j<=2;j++)
            {
                if((i==row)&&(j==column))
                {
                    x[i][j] = ' ';
                    continue;
                }
                a = (int)((Math.random()* 8) + 1);
                while(b[a-1]==true)
                    a = (int)((Math.random()* 8) + 1);
                x[i][j] = (char)(a+'0');
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
            if(row!=2)
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
            if(column!=2)
            {
                x[row][column] = x[row][column+1];
                column++;
            }
        }
        x[row][column] = ' ';
    }

    boolean answer()
    {
        if((x[0][0]=='1')&&(x[0][1]=='2')&&(x[0][2]=='3')&&(x[1][0]=='4')&&(x[1][1]=='5')&&(x[1][2]=='6')&&(x[2][0]=='7')&&(x[2][1]=='8'))
            return true;
        return false;
    }

    void cheat()
    {
        int r1,c1,r2,c2;
        char temp;
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
        Puzzle ob = new Puzzle();
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
