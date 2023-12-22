from alphabet_creator import create_alphabet
from functools import reduce
import common as c
import sys


if __name__ == "__main__":
  name = "tests/"
  if len(sys.argv) == 1:
    name += "test1.txt"
  else:
    name += sys.argv[1]
  with open(name,"r") as f:
    n = f.readline()
  n = int(n)
  alph,rel_graph = create_alphabet(n)
  in_rel,_ = c.get_relations(alph, rel_graph)
  directed_graph = c.create_directed_graph(alph,rel_graph)
  c.discarding_DFS(directed_graph)
  c.BFS(directed_graph)
  print(f"D={list(map(lambda x: f"({x[0]}|{x[1]})",in_rel))}\n")
  print(f"Word: ({reduce(lambda x,y: f"{x}|{y}",alph)})\n")
  print(f"Foata: {c.to_FNF(directed_graph)}\n")
  dot = c.to_Diagraph(directed_graph,"diekert_graph")
  dot.render(directory='order_output')
  print(dot.source)
  with open("order_output/foata.txt","w") as f:
    f.write(c.to_FNF(directed_graph))