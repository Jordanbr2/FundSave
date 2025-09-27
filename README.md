# FundSave GUI Program
by: Jordan Lin, Yuriy Neyra Alvarado, Alok Mantri  

## Brief Description / Motivation  
FundSave is a Java program that helps many young adults manage money more effectively by combining 3 major features: displaying and searching investment options, tracking budgets/savings, and showing the user’s overall financial status. The program will store expenses, investments, and most importantly, user data. File I/O will allow users to save and load their financial information to/from files between sessions. Users can search for stocks by their CUSIP number. There will be a parent Investment class, with subclasses Stock, Crypto, and ETF, which demonstrate inheritance and polymorphism. A Swing GUI is going to provide a user-friendly interface with input validation at each step, leaving no room for error.  

---

## List of Features  

### 1. Displaying Investment Options  
- Displays investment options in a sorted alphabetical order to the user.  

### 2. Search Investment Options  
- Displays whether an investment option exists.  
- If it exists: display the information about it.  
- If not: display a not-found message.  
- The user can enter the CUSIP number of the stock to search for it.  

### 3. Budget, Savings, and Investment Tracker  
- Allows the user to enter their personal information and track their budgets, savings, and investments.  
- The program also allows the user to add and delete them.  

### 4. Display the User’s Financial Information  
- Calculates and displays the financial information of the user.  

---

## Technologies / Tools Used  
- **Java** → Core programming language  
- **Java Swing (via CodeHS)** → GUI for a user-friendly interface  
- **Java I/O** → Reading/writing files (User Data)  
- **Object-Oriented Programming (OOP)** → Inheritance, polymorphism (Different types of Investments)  

---

## Getting Started / Usage  
- Compile and run the Java files in any IDE that supports Java Swing(ex.Use **CodeHS** Java Swing environment ).  

---

## Results / Performance  
- ![FundSave GUI Screenshot](https://github.com/Jordanbr2/FundSave/blob/8d62ed1cb8a7288ea5230fd02d120b47f7d60a86/FundSave.PNG)


---

## Links / References  
- [Feasibility Study](https://docs.google.com/document/d/1v9ymldQQ_NrGZBl2pHlaVwcOlV0Hu_7zm0otCvv-AVc/edit?usp=sharing)
