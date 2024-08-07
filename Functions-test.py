def my_function(aList) :
    print(aList)
    aList.append(3)

my_list = [1]
my_function(my_list)
my_function(my_list)
my_function(my_list)

def funct2() :
    global a
    a = 1234

a = 4
funct2 ()
print('part (b)', a)

def func3() :
    a.append(5)

a = [2, 3, 4]
func3()
print('part (c)', a)

def func4() :
    a.append(5)

a = [2, 3, 4]
func4()
print('part (d)', a)

def my_function(List2):
    print('Are MY_List and List2 the same object? ', MY_List is List2)
    List2.append(3)
    print('Are MY_List and List2 the same object? ', MY_List is List2)
    print(List2)
    List3 =[5,6]
    List2 = List3
    List2.append(3)
    print('Are MY_List and List2 the same object? ', MY_List is List2)
    print(List2)
MY_List = [1]
my_function(MY_List)