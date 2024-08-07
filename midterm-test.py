def func(lst1, lst2):
    for item in lst1:
        if item in lst2:
            return True
    return False

example = ["tutu", "tu"]
example2 = ["tutu"]
res = func(example, example2)
print(res)
