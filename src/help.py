import subprocess
import os

PROJECT_PATH = "."

def get_files(path):
    exts = (".java", ".xml", ".md")
    for root, _, files in os.walk(path):
        for f in files:
            if f.endswith(exts):
                yield os.path.join(root, f)

def load_project():
    content = ""
    for f in get_files(PROJECT_PATH):
        with open(f, "r", encoding="utf-8") as file:
            content += f"\n\n### {f}\n{file.read()}"
    return content

def ask_ollama(prompt):
    result = subprocess.run(
        ["ollama", "run", "Qwen2.5-Coder"],
        input=prompt.encode("utf-8"),
        capture_output=True
    )
    print(result.stdout.decode("utf-8"))

if __name__ == "__main__":
    question = input("Question projet : ")
    context = load_project()
    prompt = f"Voici le code du projet Java :\n{context}\n\nQuestion : {question} releve uniquements les problemes que peuvent rencontrer mon code ainsi que si il suit bien le modele  MVC et les patterns Observer"
    ask_ollama(prompt)