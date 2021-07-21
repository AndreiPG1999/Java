#include<iostream>
#include<fstream>
#include<conio.h>
#include<stdlib.h>
#include<dos.h>
#include<iomanip>
#include<windows.h>
#include<array>

using namespace std;
void loading_bar(int n)
{
	char a = 219;
	cout << "\r";
	cout << "\t\t\t\t\t";
	for (int i = 0; i < n; i++)
	{
		cout << a;
		Sleep(100);
	}
	system("CLS");
}
string gen_random_invoice(const int len)
{
	string tmp_s;
	static const char alphanum[] = 
		"0123456789"
		"ABCDEFGHIJKLMNOPQRSTUVWYXZ"
		"abcdefghijklmnopqrstuvwxyz";
	srand((unsigned)time(NULL) * GetCurrentProcessId());
	tmp_s.reserve(len);
	for (int i = 0; i < len; i++)
	{
		tmp_s += alphanum[rand() % sizeof(alphanum) - 1];
	}
	return tmp_s;
}
void login()
{
	string pass;
	string user;
	char chu,chp;
	cout << "\t\t\t\t\t      CAR RENTAL SYSTEM\n";
	cout << "\t\t\t\t\t----------------------------\n";
	cout << "\t\t\t\t\t           LOGIN\n";
	cout << "\t\t\t\t\t----------------------------\n";
	cout << "\t\t\t\t\t   Enter username: ";
	cin >> user;
	/*chu = _getch();
	while (chu != 13)
	{
		user.push_back(chu);
		cout << chu;
		chu = _getch();
	}*/
	cout << endl;
	cout << "\t\t\t\t\t----------------------------\n";
	cout << "\t\t\t\t\t   Enter password: ";
	chp = _getch();
	
	while (chp != 13)//13 is ENTER
	{
		pass.push_back(chp);
		cout << "*";
		chp=_getch();
	}
	cout << endl;
	if (user == "user" && pass == "pass")
	{
		cout << "\t\t\t\t\t       ACCESS GRANTED!\n";
		Sleep(500);
		system("CLS");
	}
	else
	{
		cout << "\t\t\t\t\tAccess denied! Please try again!\n";
		login();
	}
}
bool SSN_check(string SSN)
{
	if (SSN.size() == 9)
		return true;
	else
		return false;
}

class customer {
public:
	string customer_first_name;
	string customer_last_name;
	string SSN;
	int car_model;
	string car_number;
	string color;
	char data;
	string invoice = gen_random_invoice(8);
};
class rent :public customer {
public:
	int days = 0, rental_fee = 0;
	void data()
	{
		cout << "\t\t\t\t\t-------------------------------------" << endl;
		cout << "\t\t\t\t\tPlease Introduce your first name: ";
		cin >> customer_first_name;
		cout << "\t\t\t\t\tPlease Introduce your last name: ";
		cin >> customer_last_name;
		do {
			try {
				cout << "\t\t\t\t\tPlease introduce your Social Security Number:";
				cin >> SSN;
				if (SSN_check(SSN))
				{
					cout << "\t\t\t\t\tYour social security number is valid!" << endl;
					Sleep(300);
				}
				else
					throw (SSN);
			}
			catch (string SSN)
			{
				cout << "\t\t\t\tYour social security number is invalid! Please try again!" << endl;
			}
		} while (!SSN_check(SSN));
		system("CLS");
		Sleep(500);
		cout << endl;
		do {
			cout << "\t\t\t\t\t--------------------------------------------------------------" << endl;
			cout << "\t\t\t\t\tPlease select a car: " << endl;
			cout << "\t\t\t\t\tIntroduce 1 for Tesla Model 3 2021. Fee = 56 dollars/day" << endl;
			cout << "\t\t\t\t\tIntroduce 2 for Mercedes E Class 2020. Fee = 60 dollars/day" << endl;
			cout << "\t\t\t\t\tIntroduce 3 for Audi A8L 2021. Fee = 75 dollars/day" << endl;
			cout << "\t\t\t\t\tIntroduce 4 for Audi RS7. Fee = 100 dollars/day" << endl;
			cout << "\t\t\t\t\tIntroduce 5 for Ferrari LaFerrari. Fee = 300 dollars/day" << endl;
			cout << "\t\t\t\t\tIntroduce 6 for Bugatti Chiron. Fee = 1000 dollars/day" << endl;
			cout << "\t\t\t\t\t--------------------------------------------------------------" << endl;
			cout << endl;
			cout << "\t\t\t\t\tIntroduce your option: ";
			cin >> car_model;
			cout << endl;
			system("CLS");
			cout << "\t\t\t\t\t-------------------------------------------------" << endl;
			switch (car_model)
			{
			case 1:
			{
				cout << "\t\t\t\t\tYou have chosen Tesla Model 3 2021! Good choice!" << endl;
				Sleep(500);
				break;
			}
			case 2:
			{
				cout << "\t\t\t\t\tYou have chosen Mercedes E Class 2020! Good choice!" << endl;
				Sleep(500);
				break;
				
			}
			case 3:
			{
				cout << "\t\t\t\t\tYou have chosen Audi A8L 2021! Good choice!" << endl;
				Sleep(500);
				break;
				
			}
			case 4:
			{
				cout << "\t\t\t\t\tYou have chosen Audi RS7! Good choice!" << endl;
				Sleep(500);
				break;

			}
			case 5:
			{
				cout << "\t\t\t\t\tYou have chosen Ferarri LaFerarri! Good choice!" << endl;
				Sleep(500);
				break;

			}
			case 6:
			{
				cout << "\t\t\t\t\tYou have chosen Bugatti Chiron! Good choice!" << endl;
				Sleep(500);
				break;

			}
			default:
				break;
			}
		} while (car_model != 1 && car_model != 2 && car_model != 3 && car_model != 4 && car_model != 5 && car_model != 6);
		bool exists = false;
		array<string, 5> car_colors = { "black","white","green","red","yellow" };
		cout << "\t\t\t\t\t-----------------------------------------------" << endl;
		cout << "\t\t\t\t\tPlease provide the following information: " << endl;
		do {
			cout << "\t\t\t\t\tPlease select a car color: ";
			cin >> color;
			for (int i = 0; i < 5; i++)
			{
				if (car_colors[i] == color)
				{
					exists = true;
					break;
				}
			}
			if (exists == false)
				cout << "\t\t\t\t\tWe don't have that color, please choose another one!" << endl;
		} while (exists == false);
		cout << "\t\t\t\t\tNumber of days you wish to rent the car: ";
		cin >> days;
		cout << endl;
		system("CLS");
	}
	void calculate()
	{
		Sleep(200);
		cout << "\t\t\t\t\tCalculating rent. Please wait..." << endl;
		//Sleep(2000);
		loading_bar(32);
		if (car_model == 1)
			rental_fee = days * 56;
		if (car_model == 2)
			rental_fee = days * 60;
		if (car_model == 3)
			rental_fee = days * 75;
		if (car_model == 4)
			rental_fee = days * 100;
		if (car_model == 5)
			rental_fee = days * 300;
		if (car_model == 6)
			rental_fee = days * 1000;
	}
	void save_in_file()
	{
		fstream file;
		file.open("customers.txt", ios::app | ios::out);
		file << "Invoice: " << invoice << endl;
		file << "Customer first name: " << customer_first_name << endl;
		file << "Customer last name: " << customer_last_name << endl;
		file << "Social security number:" << SSN << endl;
		file << "Car model: " << car_model << endl;
		file << "Car color: " << color << endl;
		file << "Number of days: " << days << endl;
		file << "Rental fee: " << rental_fee << endl;
		file << "---------------------------------------" << endl;
	}
	void show_rent()
	{
		char rent_another;
		cout << "\n\t\t\t\t\tCar rental-Customer Invoice" << endl;
		cout << "\t\t\t\t\t-----------------------------------------" << endl;
		cout << "\t\t\t\t\tInvoice no. " << invoice << endl;
		cout << "\t\t\t\t\tCustomer first name: " << customer_first_name << endl;
		cout << "\t\t\t\t\tCustomer last name: " << customer_last_name << endl;
		cout << "\t\t\t\t\tSocial security number:" << SSN << endl;
		cout << "\t\t\t\t\tCar model: " << car_model << endl;
		cout << "\t\t\t\t\tCar color: " << color << endl;
		cout << "\t\t\t\t\tNumber of days: " << days << endl;
		cout << "\t\t\t\t\tYour rental amount is: " << rental_fee<<" dollars" << endl;
		cout << "\t\t\t\t\t-----------------------------------------" << endl;
		save_in_file();
		cout << "\t\t\t\t\tDo you want to rent another car?(y/n): ";
		cin >> rent_another;
		system("CLS");
		if (rent_another == 'y' || rent_another == 'Y')
		{
			data();
			calculate();
			show_rent();
		}
		else
			cout << "\t\t\t\t\tTHANK YOU!"<<endl;

	}
};
int main()
{
	rent obj;
	login();
	obj.data();
	obj.calculate();
	obj.show_rent();
	return 0;
}