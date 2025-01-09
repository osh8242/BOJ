number = int(input());
caseList = [];

for i in range(number) :
    a = input().split(' ');
    caseList.append(a);

for i in range(number) :
    print('Case #' + str(i +1) +': '+ caseList[i][0] + ' + '+ caseList[i][1] +' = ' + str(int(caseList[i][0]) + int(caseList[i][1])));
    