# Introduction
```
1<<n = 2^n
get ith Set bit Number: (1<<i)
get ith Unset bit Number: ~(1<<i)

## Check ith bit of a Number is Set or Not
if((a&(1<<i))!=0) cout<<"Yes";
```

```
a&1 == 1 (Odd digit)
a>>1 -> Divided by 2
a<<1 -> Multiply by 2
```
# References
* https://medium.com/@maityamit/bit-manipulation-basics-for-beginners-concepts-with-all-curated-problems-on-leetcode-b3f25d299329
* https://leetcode.com/discuss/study-guide/4282051/all-types-of-patterns-for-bits-manipulations-and-how-to-use-it