import React from "react";
import { Component } from "react";
import "./App.css";
import { BrowserRouter as Router, Redirect, Route } from "react-router-dom";
import Authors from "../Authors/authors";
import Countries from "../Countries/countries";
import Books from "../Books/books";
import Header from "../Header/header";
import EShopService from "../../repository/eshopRepository";
import BookAdd from "../Books/BookAdd/bookAdd";
import BookEdit from "../Books/BookEdit/bookEdit";
import Categories from "../Categories/categories";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      authors: [],
      countires: [],
      books: [],
      categories: [],
      selectedBook: {},
    };
  }

  render() {
    return (
      <Router>
        <Header />
        <Route>
          <main>
            <div className="container">
              <Route
                path={"/authors"}
                exact
                render={() => <Authors authors={this.state.authors} />}
              />
              <Route
                path={"/countries"}
                exact
                render={() => <Countries countries={this.state.countires} />}
              />
              <Route
                path={"/categories"}
                exact
                render={() => <Categories categories={this.state.categories} />}
              />
              <Route
                path={"/books/add"}
                exact
                render={() => (
                  <BookAdd
                    authors={this.state.authors}
                    countries={this.state.countires}
                    categories={this.state.categories}
                    onAddBook={this.addBook}
                  />
                )}
              />
              <Route
                path={"/books/edit/:id"}
                exact
                render={() => (
                  <BookEdit
                    authors={this.state.authors}
                    countries={this.state.countires}
                    categories={this.state.categories}
                    onEditBook={this.editBook}
                    book={this.state.selectedBook}
                  />
                )}
              />
              <Route
                path={"/books"}
                exact
                render={() => (
                  <Books
                    books={this.state.books}
                    onDelete={this.deleteBook}
                    onEdit={this.getBook}
                    onTakeBook={this.takeBook}
                  />
                )}
              />
              <Redirect to={"/books"} />
            </div>
          </main>
        </Route>
      </Router>
    );
  }

  loadAuthors = () => {
    EShopService.fetchAuthors().then((data) => {
      this.setState({
        authors: data.data,
      });
    });
  };

  loadCountries = () => {
    EShopService.fetchCountries().then((data) => {
      this.setState({
        countires: data.data,
      });
    });
  };

  loadBooks = () => {
    EShopService.fetchBooks().then((data) => {
      this.setState({
        books: data.data,
      });
    });
  };

  loadCategories = () => {
    EShopService.fetchCategories().then((data) => {
      this.setState({
        categories: data.data,
      });
    });
  };

  deleteBook = (id) => {
    EShopService.deleteBook(id).then(() => this.loadBooks());
  };

  addBook = (name, category, author, availableCopies) => {
    EShopService.addBook(name, category, author, availableCopies).then(() =>
      this.loadBooks()
    );
  };

  getBook = (id) => {
    EShopService.getBook(id).then((data) => {
      this.setState({
        selectedBook: data.data,
      });
    });
  };

  editBook = (id, name, category, author, availableCopies) => {
    EShopService.editBook(id, name, category, author, availableCopies).then(
      () => this.loadBooks()
    );
  };

  takeBook = (id) => {
    EShopService.takeBook(id).then(() => this.loadBooks());
  };

  componentDidMount() {
    this.loadAuthors();
    this.loadCountries();
    this.loadBooks();
    this.loadCategories();
  }
}

export default App;
