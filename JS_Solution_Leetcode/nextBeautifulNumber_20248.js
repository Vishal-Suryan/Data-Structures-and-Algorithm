const isBalanced = (num) => {
  const freq = Array(10).fill(0);
  let temp = num;

  while (temp !== 0) {
    const digit = temp % 10;
    freq[digit]++;
    temp = Math.floor(temp / 10);
  }

  for (let i = 0; i < 10; i++) {
    if (freq[i] !== 0 && freq[i] !== i) return false;
  }
  return true;
};

// Check numbers from n+1 upwards
for (let i = n + 1; i < 1_000_000_000; i++) {
  if (isBalanced(i)) return i;
}

return -1;
