from tkinter import Frame
from tkinter import simpledialog
from tkinter import messagebox

class Addition( Frame ):
    def __init__( self ):
        Frame.__init__( self )
        self.master.title("Addition")
        firstNumber = simpledialog.askinteger("Addition","First number")
        secondNumber = simpledialog.askinteger("Addition","Second number")
        summa = firstNumber + secondNumber
        messagebox.showinfo( "Message", "The sum of " + str(firstNumber) + " and " + str(secondNumber) + " is " + str(summa))

def main():
    Addition().mainloop()

# starts event loop
if __name__ == "__main__":
    main()
