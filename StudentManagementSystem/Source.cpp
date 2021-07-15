#include<iostream>
#include<fstream>
#include<cstdlib>
#include<stdlib.h>
#include<vector>
#include <regex>
using namespace std;
class student {
private:
	string name, registration_no, address, email, contact;
	double yearly_average;
public:
	void menu();
	void insert();
	void display();
	void modify();
	void search();
	void deleted();
	bool email_check(string);
	bool check_reg_no(string);
	bool check_average(double);
};
bool student::email_check(string email)
{
	const regex pattern("(\\w+)(\\.|_)?(\\w*)@(\\w+)(\\.(\\w+))+");
	return regex_match(email, pattern);
}
bool student::check_reg_no(string registration_no)
{
	if (registration_no.size() == 10)
		return true;
	else
		return false;
}
bool student::check_average(double yearly_avg)
{
	if (yearly_avg <= 10)
		return true;
	else
		return false;
}
void student::insert()
{
	int n;
	fstream file;
	cout << "Enter name: ";
	cin >> name;
	do {
		try {
			cout << "Enter registration number: ";
			cin >> registration_no;
			if (check_reg_no(registration_no))
				cout << "Registration number size is valid!" << endl;
			else
				throw (registration_no);
		}
		catch (string registration_no)
		{
			cout << "Registration number size is invalid(must be 10 characters)!" << endl;
		}
	} while (!check_reg_no(registration_no));
	
	cout << "Enter address: ";
	cin >> address;
	do {
		try {
			cout << "Enter email: ";
			cin >> email;
			if (email_check(email))
				cout << "Email valid!" << endl;
			else
				throw (email);
		}
		catch (string email)
		{
			cout << "Email invalid! Email template is example@something.com" << endl;
		}
	} while (!email_check(email));
	cout << "Enter contact: ";
	cin >> contact;
	do {
		try {
			cout << "Introduce your yearly average: ";
			cin >> yearly_average;
			if (check_average(yearly_average))
				cout << "Your average is valid!" << endl;
			else
				throw (yearly_average);
		}
		catch (double yearly_average)
		{
			cout << "Average is invalid! Must be lower or equal to 10 and must be a number!" << endl;
		}
	} while (!check_average(yearly_average));
	
	file.open("student.txt", ios::out | ios::app);
	file << name << " " << registration_no << " " << address << " " << email << " " << contact << " " << yearly_average << " ";
	file.close();
}
void student::menu() {
	int opt;
	char x;
	do {
		cout << "1. Enter new record" << endl;
		cout << "2. Display record" << endl;
		cout << "3. Modify record" << endl;
		cout << "4. Search record" << endl;
		cout << "5. Delete record" << endl;
		cout << "0. Exit" << endl;
		cout << "Enter your option: ";
		cin >> opt;
		switch (opt)
		{
		case 1:
			do {
				insert();
				cout << "Do you want to add another record?(y,n): ";
				cin >> x;
			} while (x == 'y' || x == 'Y');
			break;
		case 2:
			display();
			break;
		case 3:
			modify();
			break;
		case 4:
			search();
			break;
		case 5:
			deleted();
			break;
		case 0:exit(0);
		default:cout << "Wrong option!\n";
		}
	} while (opt);
}
void student::display()
{
	int total=0;
	fstream file;
	file.open("student.txt", ios::in);
	if (!file)
	{
		cout << "The file does not exist!";
		file.close();
	}
	else
	{
		file >> name >> registration_no >> address >> email >> contact >> yearly_average;
		while (!file.eof())
		{
			cout << "------------------------------------" << endl;
			cout << "Student nr. " << ++total << endl;
			cout << endl;
			cout << "Name:" << name << endl;
			cout << "Registration number:" << registration_no << endl;
			cout << "Address:" << address << endl;
			cout << "Email:" << email << endl;
			cout << "Contact:" << contact << endl;
			cout << "Yearly average: " << yearly_average << endl;
			file >> name >> registration_no >> address >> email >> contact >> yearly_average;
		}
		if (total == 0)
			cout << "No data is present! " << endl;
	}
	file.close();
}
void student::modify()
{
	int n;
	double grade;
	string mod_name;
	fstream file, file1;
	int found = 0;
	file.open("student.txt", ios::in);
	if (!file)
	{
		cout << "No data present!";
		file.close();
	}
	else
	{
		cout << "Enter the name of the student that you want to modify: ";
		cin >> mod_name;
		file1.open("Record.txt", ios::app | ios::out);
		file >> name >> registration_no >> address >> email >> contact >> yearly_average;
		while (!file.eof())
		{
			if (name != mod_name)
			{
				file1 << name << " " << registration_no << " " << address << " " << email << " " << contact << " " << yearly_average << " ";
			}
			else {
				cout << "Enter name: ";
				cin >> name;
				do {
					try {
						cout << "Enter registration number: ";
						cin >> registration_no;
						if (check_reg_no(registration_no))
							cout << "Registration number size is valid!" << endl;
						else
							throw (registration_no);
					}
					catch (string registration_no)
					{
						cout << "Registration number size is invalid(must be 10 characters)!" << endl;
					}
				} while (!check_reg_no(registration_no));
				cout << "Enter address: ";
				cin >> address;
				do {
					try {
						cout << "Enter email: ";
						cin >> email;
						if (email_check(email))
							cout << "Email valid!" << endl;
						else
							throw (email);
					}
					catch (string email)
					{
						cout << "Email invalid! Email template is example@something.com" << endl;
					}
				} while (!email_check(email));
				cout << "Enter contact: ";
				cin >> contact;
				do {
					try {
						cout << "Introduce your yearly average: ";
						cin >> yearly_average;
						if (check_average(yearly_average))
							cout << "Your average is valid!" << endl;
						else
							throw (yearly_average);
					}
					catch (double yearly_average)
					{
						cout << "Average is invalid! Must be lower or equal to 10 and must be a number!" << endl;
					}
				} while (!check_average(yearly_average));
				file1 << name << " " << registration_no << " " << address << " " << email << " " << contact << " " << yearly_average << " ";
				found++;
			}
			file >> name >> registration_no >> address >> email >> contact >> yearly_average;
		}
		if (found == 0)
		{
			cout << "Student name not found!\n";
		}
		file.close();
		file1.close();
		remove("student.txt");
		rename("Record.txt", "student.txt");
	}
}
void student::search()
{
	fstream file;
	string search_name;
	int found = 0;
	file.open("student.txt", ios::in);
	if (!file)
		cout << "File not found!";
	else
	{
		cout << "Introduce the name of the student that you want to search: ";
		cin >> search_name;
		file >> name >> registration_no >> address >> email >> contact >> yearly_average;
		while (!file.eof())
		{
			if (search_name == name)
			{
				cout << "------------------------------------" << endl;
				cout << endl;
				cout << "Name:" << name << endl;
				cout << "Registration number:" << registration_no << endl;
				cout << "Address:" << address << endl;
				cout << "Email:" << email << endl;
				cout << "Contact:" << contact << endl;
				cout << "Yearly average:" << yearly_average << endl;
				found++;
			}
			file >> name >> registration_no >> address >> email >> contact >> yearly_average;
		}
	}
	if (found == 0)
		cout << "The student was not found!" << endl;
	else if(found == 1)
		cout << "The student was found!" << endl;
	else if(found > 1)
		cout << "The students were found!" << endl;
	file.close();
}
void student::deleted()
{
	string name_to_delete;
	fstream file, file1;
	int found = 0;
	file.open("student.txt", ios::in);
	if (!file)
	{
		cout << "File is empty\n";
	}
	else
	{
		cout << "Introduce the name of the student that you want to delete: ";
		cin >> name_to_delete;
		file1.open("record.txt", ios::out | ios::app);
		file >> name >> registration_no >> address >> email >> contact >> yearly_average;
		while (!file.eof())
		{
			if (name_to_delete != name)
			{
				file1 << name << " " << registration_no << " " << address << " " << email << " " << contact << " " << yearly_average<<" ";
				cout << endl;
			}
			else
			{
				found++;
				cout << "Data deleted successfully!" << endl;
			}
			file >> name >> registration_no >> address >> email >> contact >> yearly_average;
		}
		if (found == 0)
			cout << "Student not in the file!";
		file1.close();
		file.close();
		remove("student.txt");
		rename("record.txt", "student.txt");
	}
}
int main()
{
	fstream file;
	//file.open("student.txt", std::ofstream::out | std::ofstream::trunc);
	student project;
	project.menu();
	return 0;
}