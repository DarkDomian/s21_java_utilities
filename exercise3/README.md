# Math insights, for fast doubling Fibonacci

Egyptian multiplication reduces products to binary decomposition of the multiplier via sequential doublings $O(\log n)$. Fast doubling applies identical logic to Fibonacci indices.

**State vector and transition matrix**:  
The recurrence $F_{k+1} = F_k + F_{k-1}$ is linear. Define the state vector

```math
\mathbf{v}_n = \begin{pmatrix} F_n \\ F_{n-1} \end{pmatrix}
```

The transition to the next state is

```math
\mathbf{v}_{n+1} = 
\begin{pmatrix} 1 & 1 \\ 1 & 0 \end{pmatrix}
\mathbf{v}_n.
```
Let
  
```math
M = \begin{pmatrix} 1 & 1 \\ 1 & 0 \end{pmatrix}.
```

Then $M^n$ encodes the $n$-th step. By induction,  

```math
M^n = \begin{pmatrix} F_{n+1} & F_n \\ F_n & F_{n-1} \end{pmatrix}.
```

**Doubling via matrix squaring**:  
To advance from index $n$ to $2n$, square the matrix power:  

```math
M^{2n} = (M^n)^2.
```

Substituting the explicit form of $M^n$ and multiplying yields the entries of $M^{2n}$. Comparing the top-left and top-right entries gives exactly the doubling identities:  

```math
F_{2n+1} = F_{n+1}^2 + F_n^2,
```

```math
F_{2n} = F_{n+1}F_n + F_nF_{n-1} 
      = F_n\bigl(2F_{n+1} - F_n\bigr).
```

These identities let the pair $F_n, F_{n+1}$ produce $F_{2n}, F_{2n+1}$. Traversing the binary bits of the target $k$ from MSB to LSB—doubling the current index per bit and incrementing for each `1` bit—computes $F(k)$ in $O(\log k)$ multiplications/additions.