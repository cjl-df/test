// return React.Children.map(props.children.props.children, (child) => {
//   return React.cloneElement(child, { setNavRight: setNavRight });
// });

interface test {
  [propkey in keys]: string;
}

enum keys {
  "name",
  "age",
  "size",
}
