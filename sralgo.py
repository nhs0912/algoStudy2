# x 좌표
xList = []
# y 좌표
yList = []
testCase = int(input())

pointList = []
# x,y좌표 입력하기
for i in range(testCase):
    x, y = input().split()
    xList.append(int(x))
    yList.append(int(y))

smallPointIndex = 0
smallPointSum = xList[0] + yList[0]
previousPointSumIndex = 0
for i in range(1, len(xList)):
    currentSum = xList[i] + yList[i]
    if currentSum < smallPointSum:
        previousPointSumIndex = smallPointIndex
        smallPointSum = currentSum
        smallPointIndex = i

print("가장 작은 previous point==")
print(xList[previousPointSumIndex], ",", yList[previousPointSumIndex])

print("가장 작은 point==")
print(xList[smallPointIndex], ",", yList[smallPointIndex])


def getDistance(x, y):
    x = x ** 2
    y = y ** 2
    sum = x + y
    return round(sum ** 0.5, 2)


xSum = xList[previousPointSumIndex] - xList[smallPointIndex]

ySum = yList[previousPointSumIndex] - yList[smallPointIndex]

print(getDistance(xSum, ySum))
